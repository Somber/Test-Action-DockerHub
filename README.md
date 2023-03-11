# Test-Action-DockerHub

Crea imagen de Docker tras compilar la aplicación. Posteriormente la sube a Docker Hub

###docker run:
docker run -d --name api-test -p 8081:8081 somber/api-test_img:tagname