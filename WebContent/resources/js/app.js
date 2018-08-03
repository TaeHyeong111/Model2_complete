var mem = (function() {
}()); // function(){}();
(function() {
})();// Goofy
(function() {
}()) // grooby



/*
 * var service = (()=>{ return { nullChecker : x=>{ var i = 0; var j = { checker :
 * true, text : '필수입력값이 없습니다' }; for(i in x){ if(x[i] === ''){ j.checker =
 * false; } return j; }, addClass : (dom,cName)=>{ var arr = cName.split(" ");
 * if(arr.indexOf(cName) == -1){ dom.className += " " + cName; } } }
 * 
 * })();
 */

var service = (()=>{
	return {
		nullChecker : x=>{
			var i = 0;
			var j = {
					checker : true,
					text : '필수입력값이 없습니다'
			};
			for(i in x){
				if(x[i] === ''){
					j.checker = false;
				}
			}
			return j;
			
				},
				addClass : (dom,cName)=>{
					var arr = cName.split(" ");
					if(arr.indexOf(cName) == -1){
						dom.className += " " + cName;
			}
		}
	}
})();

// ${ctx}','member','move','joinForm

var member = (()=> {
	   var _name, _userid, _ssn, _password,_gender,_age,_roll,_teamid;
	   var setName = (name)=> {this._name = name;}
	   var setUserid = (userid)=> {this._userid = userid;}
	   var setPassword = (password)=> {this._password = password;}
	   var setSsn = (ssn)=> {this._ssn = ssn;}
	   
	   
	   var setAge = x=>{
	    	var date = new Date().getFullYear();
	    	this._age = date - 1900 + 1 - x.substring(0,2);
	    	/* this._age = date - 1900 + 1 - x.getSsn.substring(0,3); */
	    	}
	   var setGender = x => {
			   if(x.substring(7,8)==='1'){
				   this._gender = 'man';
			   }else{
				   this._gender = 'woman';
			   }
	   }

	   var getName = ()=> {return this._name;}
	   var getUserid = ()=> {return this._userid;}
	   var getSsn = ()=> {return this._ssn;}
	   var getPassword = ()=> {return this._password;}
	   var getGender = ()=> {return this._gender;}
	   var getAge = ()=> {return this._age;}
	   return{
	       setName : setName,
	       setUserid : setUserid,
	       setSsn : setSsn,
	       setPassword : setPassword,
	       setGender : setGender,
	       setAge : setAge,
	       getName : getName,
	       getUserid : getUserid,
	       getSsn: getSsn,
	       getPassword : getPassword,
	       getGender : getGender,
	       getAge : getAge,
	       join : x =>{
	           member.setAge(x);
	           member.setGender(x);
	       }
	   };
	})();

/* var admin = (()=>{return{};})(); */
var admin = (()=>{ /* 디폴트생성자부분()) */
	return{
		check : x=>{
			var isAdmin = confirm('관리자입니까');
			if(isAdmin){
				var password = prompt('관리자비번을 입력바랍니다.');
				if(password == 1){
					router.move({
						ctx : x,
						domain : 'admin',
						action : 'list',
						page : 'main'});
				}else{
					alert('관리자비번이 다릅니다.');
				}
			}else{
				alert('관리자만 접근이 허용됩니다.');
			}
			
		}
	};})();

var admin = (()=>{ /* 디폴트생성자부분()) */
	return{
		check : x=>{
			var isAdmin = confirm('관리자입니까');  // confirm 확인, 문구 전달후 무조건 true의
												// 값을 주는모양임
			if(isAdmin){
				var password = prompt('관리자비번을 입력바랍니다.'); //
				if(password == 1){
					router.move({
						context : x,
						domain : 'admin',
						action : 'list',
						page : 'main'});
				}else{
					alert('관리자비번이 다릅니다.');
				}
			}else{
				alert('관리자만 접근이 허용됩니다.');
			}
		},
		main : x=>{
				service.addClass(
						document.getElementById('searchBox'),
						'width80pt center');
				service.addClass(
						document.getElementById('searchWord'),
						'width100pt floatRight');
				service.addClass(
						document.getElementById('searchOption'),
						'floatRight ');	
				service.addClass(
						document.getElementById('searchBtn'),
						'floatRight ');	
				service.addClass(
						document.getElementById('contentBoxTab'),
						'width90pt center marginTop30px');	
				service.addClass(
						document.getElementById('contentBoxMeta'),
						'bgColorYellow ');
						
					


				 for(var i of document.querySelectorAll('.username')){
					 service.addClass(
							 i,
							 'cursor fontColorBlue');
						i.addEventListener('click',function(){
							location.href=
								x+'/admin.do?action=retrieve&'         /*요기 ctx 고쳐야할것같음*/
								+'page=memberDetail&userid='
								+this.getAttribute('id');
						
					});
				}   


				var form = document.getElementById('seachForm');
				document.getElementById('searchBtn').addEventListener('click',function(){
				            location.href=(form.searchOption.value==='userid') ?
				                x+'/admin.do?action=RETRIEVE&page=memberDetail&userid='+form.searchWord.value
				                :
				                x+'/admin.do?action=search&page=main&searchOption='+form.searchOption.value+'&searchWord='+form.searchWord.value;        
				                ;
				                alert("form.searchOption.value = " + form.searchOption.value);
				                alert("form.searchWord.value = " + form.searchWord.value);
				    });
			
		}
		
	};})();

var router = (()=> {
	return {
		move : x => { // 키값(String), 객체
			location.href =
				x.context + '/' 
				+ x.domain 
				+ '.do?action=' + x.action
				+ '&page='	+ x.page
}}; 
})();
/* 제이슨은 속성도 들어올수있고 기능도 들어올수있어 OBJECT임 */ 
/* 펑션만 있으면 개체 */
/*주석*/


