def call(String Project, String ImageTag, String dockerhubuser, String credentials_id, String usernameVariable, String passVariable){
  withCredentials([usernamePassword(credentialsId: '${credentials_id}', passwordVariable: '${usernameVariable}', usernameVariable: '${passVariable}')]) {
      sh "docker login -u ${dockerhubuser} -p ${dockerhubpass}"
  }
  sh "docker push ${dockerhubuser}/${Project}:${ImageTag}"
}
