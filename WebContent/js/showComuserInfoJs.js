function gd1() {
		var value = document.getElementById("radio1").checked;
		if (!value) {
			document.getElementById("loginname").disabled = true;
		} else {
			document.getElementById("loginname").disabled = false;
		}
	}
function gd2() {
		var value = document.getElementById("radio2").checked;
		if (!value) {
			document.getElementById("loginpass").disabled = true;
		} else {
			document.getElementById("loginpass").disabled = false;
		}
	}
function gd3() {
		var value = document.getElementById("radio3").checked;
		if (!value) {
			document.getElementById("loginpass1").disabled = true;
		} else {
			document.getElementById("loginpass1").disabled = false;
		}
	}
function gd4() {
		var value = document.getElementById("radio4").checked;
		if (!value) {
			document.getElementById("email").disabled = true;
		} else {
			document.getElementById("email").disabled = false;
		}
	}
	function gd5() {
		var value = document.getElementById("radio5").checked;
		if (!value) {
			document.getElementById("uphone").disabled = true;
		} else {
			document.getElementById("uphone").disabled = false;
		}
	}

