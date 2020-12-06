pipeline{
    agent {label 'devops'}
    tools{
        maven 'maven-3.5.2'
        jdk   'jdk1.8'
    }
    stages{
        stage("Initialize"){
            steps{
                sh '''
                    echo "PATH=${PATH}"
                    echo "MAVEN_HOME=${MAVEN_HOME}"
                '''
            }
        }
        stage("Clone source code"){
            steps{
                git 'git@github.com:wangwenjun/cicd.git'
            }
        }

        stage("Unit Test"){
            steps{
                sh 'mvn clean test "-Dtest=*Test"'
            }
            post{
                success{
                    junit '**/target/surefire-reports/*.xml'
                }
            }
        }

        stage("Function Test"){
            steps{
                sh 'mvn test "-Dtest=*Fixture,*Runner"'
            }
        }

        stage("Publish Function Testing Report"){
            steps{
                sh 'mvn cluecumber-report:reporting'
            }
        }
    }
}