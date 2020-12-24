if [ -z "$1" ]
then
    projects="customer-service email-service"

    for project in $projects
    do
        mvn -f $project/pom.xml clean package -DskipTests
        docker build -t tanawit17/$project $project/
    done
else
    mvn -f $1/pom.xml clean package -DskipTests
    docker build -t tanawit17/$1 $1/
fi