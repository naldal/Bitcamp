let xhr;

function startMethod(){
	xhr = new XMLHttpRequest();
	xhr.onreadystatechange = resultProcess;
	xhr.open("GET", "ajaxExam02.xml", true)
	xhr.send(null);
}

function resultProcess(){
	if(xhr.readyState==4){
		if(xhr.status==200){
			processXML();
		}
	}
}

function processXML(){
	//기존의 내용을 지워야 추가가 안된다
	var trChild = document.getElementById("resultDisplay").childNodes;
	//alert("개수 = "+trChild.length);
	//크롬에서는 trChild.length가 하나 지울때마다 다시 계산을 해서 index의 값이 바뀐다
	//해결책 : 거꾸로 돌리면 됨
	for(var i=(trChild.length-1); i>=0; i--) {
		trChild[i].remove();
	} //for
	
	//---------------------
	var xmlDoc = xhr.responseXML;
	var trTag = "";
	var tdTag = "";
	
	var subjects = xmlDoc.getElementsByTagName("subject");
	
	for(var i=0; i<subjects.length; i++){
		trTag = document.createElement("tr");
		
		var childs = subjects[i].childNodes;
		for(var j=0; j<childs.length; j++){
			if(childs[j].firstChild!=null){
				tdTag = document.createElement("td");
				
				tdTag.appendChild(childs[j].firstChild);
				trTag.appendChild(tdTag);
			}
		}//for j
		document.getElementById("resultDisplay").appendChild(trTag);
	}//for i
}






