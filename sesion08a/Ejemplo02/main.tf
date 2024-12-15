provider "aws" {
    region = var.region
}

#Modulo de red
module "network" {
    source = "./network"
}

#Configuración de EC2
resource "aws_instance" "main_web" {
    ami = "ami-00016c578cbc69023"
    instance_type = var.instance_type
    subnet_id = module.network.subnet_id
    vpc_security_group_ids = [module.network.security_group_id]
    tags = {
        Name = var.instance_name
    }
}
