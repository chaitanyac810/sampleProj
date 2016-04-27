import org.apache.http.client.HttpResponseException

/**
 * Created by SKtammana on 4/27/2016.
 */
class GitConnector {
    def sendSMS(){
        def client = new HTTPBuilder(https://api.github.com/users/octocat/orgs)
        client.auth.basic "admin", "admin"
        def copyToSecondary
        if(params.copyToSecondary)
            copyToSecondary=true
        else
            copyToSecondary=false

        def userName= params.userName
        def messageText = "frm :"+userName+"-"+params.messageText
        def jsonData = "'${copyToSecondary}'}"
        def data = ['info': jsonData]
        try {
            def res = client.request(Method.POST, ContentType.JSON) {
                uri.query = data
                headers.'Content-Type' = 'application/json'
                response.success = { resp ->
                    flash.message = 'contact.support.message.success'
                    redirect(action: 'contactSupport')
                }
                response.failure = { resp ->
                    flash.message = 'contact.support.message.failure'
                    redirect(action: 'contactSupport')
                }
            }
        }
        catch (HttpResponseException e) {
            println "Response exception caught."+e
        }
        catch (Exception e) {
            println "Some exception caught."+e
        }

    }


}
