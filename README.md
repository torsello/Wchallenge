# Wolox - SocialNetwork


### Before Running application ###

#### Install Lombok ####
[Lombok](https://projectlombok.org/download)

#### Environment variable ####
Before running the application, it will be necessary to create an environment variable named ___root.path___ with the directory where the __app-directory__ folder is located.
In my case, the folder is located at: __/ Users / macboockpro / Desktop / wchallenge__

So:

```bash
root.path=/Users/macboockpro/Desktop/wchallenge
```

#### Database ####
It is necessary to have a mysql database named __socialnetwork__, the application will create the tables based on the model.

* Update your db username and password on __/resources/application.yaml__
#

### App-directory ###
We will use it to store all the necessary external files.

Contains:

* Cfg (config files)
* Logs (Logs from the app)
