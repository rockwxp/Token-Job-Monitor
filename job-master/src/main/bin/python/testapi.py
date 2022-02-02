import requests
taskOwner="rock_test"
def get_token_task(taskOwner):
     url=f"https://decent-destiny-329402.uc.r.appspot.com/job-master/token/getTokenTask?taskOwner={taskOwner}"
     response = requests.get(url)
     token=response.text
     print(f"start the task {token}")
     return token

def end_token_task(taskOwner,token) :
     url=f"https://decent-destiny-329402.uc.r.appspot.com/job-master/token/endTokenTask?tokenName={token}&taskOwner={taskOwner}"
     response = requests.get(url)
     result=response.text
     if( int(result) > 0 ):
        print(f"success the task for {token}")
     else:
        print(f"failed the task for {token}")




token=get_token_task(taskOwner)

print("task processing for the token")

end_token_task(taskOwner,token)
