# Ikigai

Ikigai is a social media app designed to connect and engage remote workforces by facilitating the sharing of employees' passions through classes and activities.

## Features

- **Passion Sharing**: Employees can host classes and workshops about their passions, allowing others to participate and learn.
- **Voluntary Engagement**: Participation is optional, ensuring employees can explore passions that resonate with them personally.
- **Improved Employee Engagement**: Ikigai fosters a sense of community, personal growth, and connection among remote teams.
- **Diverse Range of Activities**: From art and music to fitness and mindfulness, employees can discover and engage in various interests.
- **Authentic Connections**: The app creates an environment that encourages genuine interactions and relationship-building.

## Running the application

The project is a standard Maven project. To run it from the command line,
type `mvnw` (Windows), or `./mvnw` (Mac & Linux), then open
http://localhost:8080 in your browser.

You can also import the project to your IDE of choice as you would with any
Maven project. Read more on [how to import Vaadin projects to different IDEs](https://vaadin.com/docs/latest/guide/step-by-step/importing) (Eclipse, IntelliJ IDEA, NetBeans, and VS Code).

## Deploying to Production

To create a production build, call `mvnw clean package -Pproduction` (Windows),
or `./mvnw clean package -Pproduction` (Mac & Linux).
This will build a JAR file with all the dependencies and front-end resources,
ready to be deployed. The file can be found in the `target` folder after the build completes.

Once the JAR file is built, you can run it using
`java -jar target/ikigai-1.0-SNAPSHOT.jar`

## Project structure

- `MainLayout.java` in `src/main/java` contains the navigation setup (i.e., the
  side/top bar and the main menu). This setup uses
  [App Layout](https://vaadin.com/docs/components/app-layout).
- `views` package in `src/main/java` contains the server-side Java views of your application.
- `views` folder in `frontend/` contains the client-side JavaScript views of your application.
- `themes` folder in `frontend/` contains the custom CSS styles.

## Useful links

- Vaddin Documentation at [vaadin.com/docs](https://vaadin.com/docs).
- Apache Maven Documentation at [maven.apache.org/guides/index](https://maven.apache.org/guides/index.html).
- Spring Framework Documentation at [docs.spring.io/spring-framework/reference/](https://docs.spring.io/spring-framework/reference/). 

## Deploying using Docker

To build the Dockerized version of the project, run

```
mvn clean package -Pproduction
docker build . -t ikigai:latest
```

Once the Docker image is correctly built, you can test it locally using

```
docker run -p 8080:8080 ikigai:latest
```
## License

This project is licensed under the [Attribution-NonCommercial 4.0 International (CC BY-NC 4.0)](https://creativecommons.org/licenses/by-nc/4.0/). Feel free to use and modify the code as per the license terms. Comercial use is not allowed.

## Contact

If you have any questions or inquiries, please contact me at peterbuckley3636@gmail.com.
