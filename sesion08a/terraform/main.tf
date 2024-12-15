provider "aws" {
  region = var.region
}

module "network" {
  source = "./network"
}

resource "aws_instance" "web" {
  ami           = "ami-0036347a8a8be83f1"
  instance_type = var.instance_type
  subnet_id     = module.network.subnet_id
  vpc_security_group_ids = [module.network.security_group_id]

  tags = {
    Name = var.instance_name
  }
}
