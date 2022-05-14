import socket

server_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
server_socket.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)

server_socket.bind(('114.71.220.163', 3333))
while True:

    server_socket.listen()

    client_socket, addr = server_socket.accept()

    print('Connected by', addr)


    data = client_socket.recv(1024)

    if not data:
        break
    print('Received form', addr, data.decode())

    client_socket.send(data)

    #data = client_socket.recv(1024)

    if not data:
        break
  
    client_socket.send("20181501".encode())
    print("send success")

    client_socket.close()
    server_socket.close()


    exit()