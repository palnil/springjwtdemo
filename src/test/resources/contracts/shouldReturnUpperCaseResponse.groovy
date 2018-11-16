package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {

    description"Should return upper case response"
    request {
        method GET()
        url("/hello")
        headers {

            header(contentType(),'application/json')
            header(authorization(),'bearer: jkasdfjhgsakdfghsdaf')
        }

       // body (accessNumber:"4155",lastFour:"3434")
    }
    response {
        status(200)
        body  (lastName: "PATEL")
    }
}