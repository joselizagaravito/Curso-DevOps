terraform {
    required_providers {
    docker = {
      source  = "kreuzwerker/docker"
      version = ">= 2.0"
        }
    }
}
provider "docker"{
    host = "npipe:////./pipe/docker_engine"
}
resource "docker_image" "nginx" {
        name = "nginx:latest"
}
resource "docker_container" "contenedor_nginx" {
    image = docker_image.nginx.latest
    name = "nginx_ejemplo01" 
    ports{
        internal = 80
        external = 9015
    }
}