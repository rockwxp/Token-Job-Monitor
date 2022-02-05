import requests
import time
import threading


def heartbeat(stop,token):
     while True:
          send_heartbeat(taskOwner,token,"running")
          time.sleep(10)
          if stop():
               break

def send_heartbeat(taskOwner,token,heartbeat_status) :
     url=f"https://decent-destiny-329402.uc.r.appspot.com/job-master/token/sendHeartbeat?tokenName={token}&taskOwner={taskOwner}&heartbeat={heartbeat_status}"
     requests.get(url)
     print(f"send {token} heartbeat to job master:{heartbeat_status}")

def get_token_task(taskOwner):
     url=f"https://decent-destiny-329402.uc.r.appspot.com/job-master/token/getTokenTask?taskOwner={taskOwner}"
     response = requests.get(url)
     token=response.text
     print(f"start the task {token}")
     return token

def end_token_task(taskOwner,token,status) :
     url=f"https://decent-destiny-329402.uc.r.appspot.com/job-master/token/endTokenTask?tokenName={token}&taskOwner={taskOwner}&status={status}"
     response = requests.get(url)
     result=response.text
     if( int(result) > 0 ):
          print(f"success the task for {token}")
     else:
          print(f"failed the task for {token}")


taskOwner="rock_test"
stop_beat = False
token=get_token_task(taskOwner)
t=threading.Thread(target = heartbeat, args =(lambda : stop_beat,token ))
try:
     t.start()
     for i in range(0,10):
          time.sleep(3)
          print(f"processing task for {token}")
except:
     end_token_task(taskOwner,token,-1)
     stop_beat = True
     send_heartbeat(taskOwner,token,"dead")
else:
     end_token_task(taskOwner,token,0)
finally:
     stop_beat = True
     t.join()
     send_heartbeat(taskOwner,token,"dead")
     print(f"end task {token} ")

