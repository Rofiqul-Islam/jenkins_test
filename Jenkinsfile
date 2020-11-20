pipeline {
    agent any

    stages {
        stage ('Build Stage') {
            steps {
                withMaven(maven: 'maven') {
                    sh 'mvn compile'
                }
            }
        }

        stage ('Testing Stage') {
            steps {
                withMaven(maven: 'maven') {
                    sh 'mvn test'
                }
            }
        }
}
}
