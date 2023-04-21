# Instalação Docker no Windows 

Requisitos: 
- Computador com suporte a Hyper Virtualization 
- Windows 10
 
 1 - Habilitando o WSL
 Abre o PowerShell como administrador e digite na linha de comando:

```
dism.exe /online /enable-feature /featurename:Microsoft-Windows-Subsystem-Linux /all /norestart
```
 
 2 - Habilitando o VPM (Virtual Machine Platform)
 No PowerShell, digite:
 
 ```
dism.exe /online /enable-feature /featurename:VirtualMachinePlatform /all /norestart
 ```
 
 3 - Reinicie o computador
 
 4 - Configurando o Hyper -V

    1 - Abra a janela "Segurança do Windows"
    2 - Selecione a opção de "Controle de aplicativos e do navegador"
    3 - Procure por "Exploit Protection" > Configurações do Exploit Protection
    4 - Troque para aba "Configurações de programa"
    5 - Procure por "C:\WINDOWS\System32\vmcompute.exe", expanda e clique em "Editar"
      - Talvez seja necessário reiniciar o computador para encontrar o path acima 
    6 - Procure por "Proteção de fluxo de controle (CGF)" e desmarque o item "Substituir configurações do sistema"
    
 5 - Setando o WSL 2:
 No PowerShell > wsl --set-default-version 2

 6 - Instale uma distribuição Linux
 Exemplo: Ubuntu https://www.microsoft.com/en-gb/p/ubuntu-2004-lts/9n6svws3rx71?activetab=pivot:overviewtab ou wsl --install -d Ubuntu
  - Apos fazer a instalação da distribuição, siga as instruções do prompt de comando da mesma
  
 7 - Instale o Docker
 - Entre no site > https://www.docker.com/get-started
 - Inicie o instalador, deixe todas as opções marcadas por default, e se necessário reinicie o computador para finalizar
 Ao final do passo 7, o Docker deve estar rodando ativamente com o WSL 2, e pronto para uso. 
 
 
 
 
 

  
