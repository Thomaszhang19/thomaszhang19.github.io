import requests, json, socket
HOST = '192.168.1.70'  
PORT = 32884       
with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
    s.bind(('', PORT))
    s.listen()
    conn, addr = s.accept()
    with conn:
        print('Connected by', addr)
        while True:
            data = conn.recv(1024)
            if not data:
                break
            api_key = "8c52c69c5646ff00a1bbb2ddb5457fa8" 
            base_url = "http://api.openweathermap.org/data/2.5/weather?"
            city_name = data.decode("UTF-8")
            complete_url = base_url + "appid=" + api_key + "&q=" + city_name 
            response = requests.get(complete_url) 
            x = response.json()
            if x["cod"] != "404":
                y = x['main'] 
                current_temperature = y["temp"] 
                current_pressure = y["pressure"] 
                current_humidity = y["humidity"]  
                z = x["weather"] 
                weather_description = z[0]["description"]
                current_temperature_c = int(current_temperature)
                current_temperature_c -= 273
                current_pressure_k = int(current_pressure)
                current_pressure_k /= 10
                t = 'Temperature (in C) = ' + str(current_temperature_c)
                p = ', Pressure (in kPa) = ' + str(current_pressure_k)
                h = ', Humidity (in %) = ' + str(current_humidity)
                w = ', Weather description = ' + str(weather_description)
                print("send temperature")
                coal = t + p + h + w
                conn.send(coal.encode("UTF-8"))
            else: 
                conn.send(b'UTFC')


