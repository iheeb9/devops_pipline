

properties([pipelineTriggers([githubPush()])])
pipeline {
    agent any 
        tools { 
        maven "MyProjectDevops"
        
    }

      

    
//  stage('Nexus') {
//             steps {
//                 script{
//           nexusPublisher nexusInstanceId: 'nexus3',
//                                           nexusRepositoryId: 'Maven-',
//                                           packages: [[$class: 'MavenPackage', 
//                                           mavenAssetList: [[classifier: '', extension: '', filePath: 'target/tpAchatProject-1.0.jar']], 
//                                           mavenCoordinate: [artifactId: 'tpAchatProject', groupId: 'com.esprit.examen', packaging: 'jar', version: '1.0']]]      
//                 }
//             }
//         } 
        stage('git clone') {
            steps {
               git branch: 'chames-devops', url: 'https://github.com/iheeb9/devops_pipline'
        
            }
        }
        stage('clean package') {
            steps {
             sh 'mvn clean install -DskipTests=true'
        
        
            }
        }
    stages {
         stage ('NEXUS DEPLOY') {
            steps {
                sh 'mvn clean package deploy:deploy-file -DgroupId=com.esprit.examen -DartifactId=tpAchatProject -Dversion=1.0 -DgeneratePom=true -Dpackaging=jar -DrepositoryId=deploymentRepo -Durl=http://172.10.0.140:8081/repository/maven-releases/ -Dfile=target/tpAchatProject-1.0.jar -DskipTests'
            }
        }
        stage('mvn test') {
            steps {
             sh 'mvn test'
        
        
            }
        }
        stage('MVN SONARQUBE') {
            steps {
                sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=sonar'
            }
        }

     
    
               
        
    
        
        
        
    }
    
    
      post{
        always{
        
        emailext body: 'jenkins', subject: 'jenkins', to: 'chames.benrezigue@esprit.tn'
        }
        
    }    
        
}
