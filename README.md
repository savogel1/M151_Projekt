# M151_Projekt
Projektarbeit im Modul 151

## Installations Anleitung
### 1. Repository klonen
````
git clone https://github.com/savogel1/M151_Projekt.git
````
### 2. Postgres Container starten
````
docker-compose up schrittzaehler-challenge-postgres
````
oder mit Docker Desktop App starten
### 3. Backend starten
````
gradlew bootRun
````
oder mit GUI in IDE starten <br>
#### ℹ Information ℹ <br>
Falls Spring nicht automatisch Tabellen mit Beispieldaten erstellen konnte, müssen zuerst die .sql Dateien unter <workspace>/M151_Projekt/backend-schrittzaehler-challenge/src/main/resources/db/migration/ manuell auf der Datenbank "postgres" ausgeführt werden.
### 4. Frontend starten 
````
npm install
ng serve
````
