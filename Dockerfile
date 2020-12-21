FROM    maven:3.6.3-jdk-11
RUN     mkdir /qualtyPointTech2
WORKDIR /qualtyPointTech2
COPY    . .
RUN ls
CMD mvn clean test -Dcucumber.options="--tags '@TC_01'" -DexecutionPlatform="GRID_CHROME"
