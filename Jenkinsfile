properties([pipelineTriggers([githubPush()])])
pipeline {
    agent any 
        tools { 
        maven "MyMaven"
<<<<<<< HEAD
		docker "Mydocker"
=======
>>>>>>> df12551a6a2dd25cb24c7c01f30e99c558fd6d10
        
    }
       

    stages {
        stage('git clone') {
            steps {
               git branch: 'main', url: 'https://github.com/iheeb9/devops_pipline'
        
            }
        }
        stage('clean package') {
            steps {
             sh 'mvn clean install'
        
        
            }
        }

        stage('Nexus') {
            steps {
<<<<<<< HEAD
             sh 'docker build -t TpAchat .'
        
        
            }
=======
                script{
          nexusPublisher nexusInstanceId: 'nexus3',
                                          nexusRepositoryId: 'Maven-',
                                          packages: [[$class: 'MavenPackage', 
                                          mavenAssetList: [[classifier: '', extension: '', filePath: 'target/tpAchatProject-1.0.jar']], 
                                          mavenCoordinate: [artifactId: 'tpAchatProject', groupId: 'com.esprit.examen', packaging: 'jar', version: '1.0']]]      
                }
        }
         
>>>>>>> df12551a6a2dd25cb24c7c01f30e99c558fd6d10
        }
        
        
        
    }
    
   
        
        
}
