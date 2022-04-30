cd /users/shadow/desktop/sandbox/university-ms/university-ms/src/main/university-ms
echo "================================================================================================================================="
echo "Checking port : 6062 to make it available for use..."
lsof -i :6062
echo "Clean...."
kill $(lsof -t -i:6062)
echo "================================================================================================================================="

ng serve --port=6062