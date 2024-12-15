# Usa la imagen oficial de Jenkins como base
FROM jenkins/jenkins:lts

# Cambia a usuario root para poder instalar las herramientas
USER root

# Actualiza los paquetes e instala dependencias necesarias
RUN apt-get update && \
    apt-get install -y apt-transport-https curl gnupg software-properties-common unzip lsb-release

# Instalar Docker CLI
RUN curl -fsSL https://download.docker.com/linux/debian/gpg | apt-key add - && \
    echo "deb [arch=amd64] https://download.docker.com/linux/debian $(lsb_release -cs) stable" | tee /etc/apt/sources.list.d/docker.list && \
    apt-get update && \
    apt-get install -y docker-ce-cli

# Instalar AWS CLI
RUN curl "https://awscli.amazonaws.com/awscli-exe-linux-x86_64.zip" -o "awscliv2.zip" && \
    unzip awscliv2.zip && \
    ./aws/install && \
    rm -rf awscliv2.zip aws

# Instalar Azure CLI
RUN curl -sL https://aka.ms/InstallAzureCLIDeb | bash

# Instalar Terraform
RUN curl -fsSL https://apt.releases.hashicorp.com/gpg | apt-key add - && \
    apt-add-repository "deb [arch=amd64] https://apt.releases.hashicorp.com $(lsb_release -cs) main" && \
    apt-get update && \
    apt-get install -y terraform

# Limpieza de caché para reducir el tamaño de la imagen
RUN apt-get clean && \
    rm -rf /var/lib/apt/lists/*

# Cambiar a usuario Jenkins
USER jenkins

# Exponer el puerto de Jenkins
EXPOSE 8080

# Configuración de trabajo de Jenkins
WORKDIR /var/jenkins_home
