exercise=$1
sudo docker run \
      --env EXERCISE=$exercise \
      --workdir /jail \
      --volume ../piscine-java:/jail/student:ro \
      -it ghcr.io/01-edu/module-java