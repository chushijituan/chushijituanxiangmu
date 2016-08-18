function gd1() {
		var value = document.getElementById("radio1").checked;
		if (!value) {
			document.getElementById("spassword").disabled = true;
		} else {
			document.getElementById("spassword").disabled = false;
		}
	}
function gd2() {
		var value = document.getElementById("radio2").checked;
		if (!value) {
			document.getElementById("spassword1").disabled = true;
		} else {
			document.getElementById("spassword1").disabled = false;
		}
	}
function gd3() {
		var value = document.getElementById("radio3").checked;
		if (!value) {
			document.getElementById("semail").disabled = true;
		} else {
			document.getElementById("semail").disabled = false;
		}
	}
function gd4() {
		var value = document.getElementById("radio4").checked;
		if (!value) {
			document.getElementById("sphone").disabled = true;
		} else {
			document.getElementById("sphone").disabled = false;
		}
	}