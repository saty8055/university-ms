echo "================================================================================================================================="
echo "Checking port : 8062 to make it available for use..."
lsof -i :8062
echo "Clean...."
kill $(lsof -t -i:8062)
echo "================================================================================================================================="

echo "Building UI Assets...."
cd /users/shadow/desktop/sandbox/university-ms/university-ms/src/main/university-ms

ng build

echo "--------------------------------------------------------------------------------------------------------------------------------"

echo "Moving to Back-end library..."

cd dist/university-ms

mv index.html ./../../../resources/templates/index.html

cd ../..

cp -R ./dist/university-ms/ ./../resources/static

echo "Cleaning unused files..."

rm -rf dist

echo "================================================================================================================================="

echo "Building & Executing API"

cd /users/shadow/desktop/sandbox/university-ms/university-ms

mvn spring-boot:run