let url = "https://reqres.in/api/users";
async function asyncGetFunc() {
	let response = await fetch(url);
	let text = await response.text(); // response body consumed
	document.write(text);
}
async function asyncHeaderFunc() {
	let response = await fetch(url);

	// get one header
	alert(response.headers.get('Content-Type')); // application/json; charset=utf-8

	// iterate over all headers
	for (let [key, value] of response.headers) {
		console.log(`${key} = ${value}`);
	}
}
// asyncHeaderFunc();
// asyncGetFunc();
async function asyncPostFunc() {
	let user = {
		name: 'John',
		job: 'Smith'
	};
	// url is a server location 
	let response = await fetch(url, {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json;charset=utf-8'
		},
		body: JSON.stringify(user)
	});
	let result = await response.headers.get('Content-Type');
	document.write(result);
}
// asyncPostFunc();
async function asyncTryFunc() {
	let user = {
		name: 'John',
		surname: 'Smith'
	};
	// url is a server location 
	let response = await fetch(url, {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json;charset=utf-8'
		},
		body: JSON.stringify(user)
	});
	try {
		let result = await response.json();
		alert(result.message);
	} catch (error) {
		console.error(error);
	}
}
// asyncTryFunc();
async function asyncThenFunc() {
	let user = {
		name: 'John',
		surname: 'Smith'
	};
	// url is a server location 
	let response = fetch(url, {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json;charset=utf-8'
		},
		body: JSON.stringify(user)
	}).then((response) => {
		let result = response.json();
		alert(result.message);
	}).catch((error) => {
		console.error(error);
	});
}

