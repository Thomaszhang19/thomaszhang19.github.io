import time
import socket
HOST = '192.168.1.70'  
PORT = 32884       
usrInput = input("Enter your city:")
with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
	s.connect((HOST, PORT))
	s.sendall(usrInput.encode('UTF-8'))
	data = s.recv(1024)
	datad = (data.decode('UTF-8'))
	if datad == "UTFC":
		print("Unable to find the city " + usrInput)
	else:
		print(datad)
time.sleep(3)

