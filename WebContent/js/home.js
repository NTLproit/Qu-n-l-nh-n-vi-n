function openNav() {
	document.getElementById("mySidenav").style.width = "250px";
	document.getElementById("main").style.marginLeft = "250px";
}
function closeNav() {
    document.getElementById("mySidenav").style.width = "0";
    document.getElementById("main").style.marginLeft = "0";
}

function validateAdd() {
	var num=document.add.addAge.value;
	var name=document.add.addName.value;
	var address=document.add.addAddress.value;
	var position=document.add.addPosition.value;
	var description=document.add.addDescription.value;
	var username=document.add.addUsername.value;
	var password=document.add.addPassword.value;
	if(name==""){
    	document.getElementById("name").innerHTML = "Khong duoc de trong.";
    	return false;
    }
	else if (isNaN(num)||num=="") {
        document.getElementById("numloc").innerHTML = "Tuoi phai nhap bang so";
        return false;
    }
    else if(address==""){
    	document.getElementById("address").innerHTML = "Khong duoc de trong.";
    	return false;
    }
    else if(position==""){
    	document.getElementById("position").innerHTML = "Khong duoc de trong.";
    	return false;
    }
    else if(username==""){
    	document.getElementById("username").innerHTML = "Khong duoc de trong.";
    	return false;
    }
    else if(password==""){
    	document.getElementById("password").innerHTML = "Khong duoc de trong.";
    	return false;
    }
    else {
        return true;
    }


}
function validateEdit() {
	var num=document.edit.editAge.value;
	var name=document.edit.editName.value;
	var address=document.edit.editAddress.value;
	var position=document.edit.editPosition.value;
	var description=document.edit.editDescription.value;
	var username=document.edit.editUsername.value;
	var password=document.edit.editPassword.value;
	if(name==""){
    	document.getElementById("name1").innerHTML = "Khong duoc de trong.";
    	return false;
    }
	else if (isNaN(num)||num=="") {
        document.getElementById("numloc1").innerHTML = "Tuoi phai nhap bang so";
        return false;
    }
    else if(address==""){
    	document.getElementById("address1").innerHTML = "Khong duoc de trong.";
    	return false;
    }
    else if(position==""){
    	document.getElementById("position1").innerHTML = "Khong duoc de trong.";
    	return false;
    }
    else if(username==""){
    	document.getElementById("username1").innerHTML = "Khong duoc de trong.";
    	return false;
    }
    else if(password==""){
    	document.getElementById("password1").innerHTML = "Khong duoc de trong.";
    	return false;
    }
    else {
        return true;
    }

}
function deleteConfirm() {
    var retVal = confirm("Ban co muon tiep tuc xoa nhan vien?");
   if( retVal == true ){
      return true;  
   }
}