<p align="center">
  <img src="https://github.com/TEWgijon/README-examples/blob/main/img/logo-epigijon.png" alt="EPI Gijón logo" width="200"/>
</p>

# Deploying the Django example

1. Create the venv:
    ```cmd 
    python3 -m venv .env
    ```
2. Activate it
    ```cmd 
    .env\Scripts\activate
    ```
3. Install django with pip
    ```cmd
    pip3 install Django
    ```
4. Perform the migration
    ```cmd
    python3 manage.py migrate
    ```
5. Deploy the server
    ```cmd
    python3 manage.py runserver
    ```