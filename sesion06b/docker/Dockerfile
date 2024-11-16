# Usar la imagen oficial de Jenkins
FROM jenkins/jenkins:lts

# Cambiar a usuario root para instalar dependencias
USER root

# Instalar paquetes básicos y dependencias
RUN apt-get update && apt-get install -y \
    apt-transport-https \
    ca-certificates \
    curl \
    gnupg \
    lsb-release \
    software-properties-common \
    unzip \
    git \
    && apt-get clean && rm -rf /var/lib/apt/lists/*

# Instalar Kubernetes CLI (kubectl) con un enfoque robusto
ARG KUBECTL_VERSION="v1.28.2"  # Cambiar si necesitas otra versión
RUN curl -LO "https://dl.k8s.io/release/${KUBECTL_VERSION}/bin/linux/amd64/kubectl" && \
    chmod +x kubectl && mv kubectl /usr/local/bin/kubectl

# Instalar Azure CLI
RUN curl -sL https://aka.ms/InstallAzureCLIDeb | bash

# Instalar Terraform
ARG TERRAFORM_VERSION="1.5.7"
RUN curl -LO "https://releases.hashicorp.com/terraform/${TERRAFORM_VERSION}/terraform_${TERRAFORM_VERSION}_linux_amd64.zip" && \
    unzip terraform_${TERRAFORM_VERSION}_linux_amd64.zip && \
    mv terraform /usr/local/bin/terraform && \
    rm terraform_${TERRAFORM_VERSION}_linux_amd64.zip

# Instalar Docker CLI
RUN curl -fsSL https://download.docker.com/linux/debian/gpg | gpg --dearmor -o /usr/share/keyrings/docker-archive-keyring.gpg && \
    echo "deb [arch=amd64 signed-by=/usr/share/keyrings/docker-archive-keyring.gpg] https://download.docker.com/linux/debian $(lsb_release -cs) stable" > /etc/apt/sources.list.d/docker.list && \
    apt-get update && apt-get install -y docker-ce docker-ce-cli containerd.io && \
    usermod -aG docker jenkins && \
    apt-get clean && rm -rf /var/lib/apt/lists/*

# Cambiar al usuario Jenkins
USER jenkins

# Preinstalar plugins de Jenkins
RUN jenkins-plugin-cli --plugins "docker-plugin pipeline-model-definition workflow-aggregator github terraform"
