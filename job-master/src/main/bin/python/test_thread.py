import time
import threading

def run(stop):
    while True:
        print("send heartbeat to job master")
        time.sleep(5)
        if stop():
            break


if __name__=='__main__':
    stop_threads = False
    t1 = threading.Thread(target = run, args =(lambda : stop_threads, ))
    t1.start()
    time.sleep(20)
    stop_threads = True
    t1.join()
    print('thread killed')

