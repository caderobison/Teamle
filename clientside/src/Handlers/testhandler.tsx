export class TestHandler {

    get() : Promise<string> {
        return fetch("/testing/get-test")
            .then(response => response.text());
    }
}

