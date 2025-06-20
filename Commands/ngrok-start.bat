@echo off
start ngrok http 8080
timeout /t 3 >nul
curl http://127.0.0.1:4040/api/tunnels
pause
