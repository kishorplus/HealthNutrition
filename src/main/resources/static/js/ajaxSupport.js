$( document ).ready(function() {
	
//	retrieve latest tab shown before refresh
	var activeTab = localStorage.getItem('activeTab');
	if(activeTab){
		$('#nav-tab a[href="#' + activeTab + '"]').tab('show');
		localStorage.setItem('activeTab', "");
		$( '.approve-success-msg' ).text( localStorage.getItem('msg') );
		localStorage.setItem('msg', "");
	}
	 	
	$('#OutlineAcceptOrNeedTiImprovemenet').on('hidden.bs.modal', function () {
		location.reload();
		

	});
	

	$('#approveContributorId').on('show.bs.tab',function () {
		location.reload();
		
		
	});
	
	$('#KeywordStatusAccept').on('hidden.bs.modal',function () {
		location.reload();
		
		
	});
	
	
	



	
	$('#videoViewIdAdmin').on('hidden.bs.modal', function () {
		location.reload();
		
	});
	
	$('#videoViewIdDomain').on('hidden.bs.modal', function () {
		location.reload();
		
	});
	
	$('#VideoStatusAccept').on('hidden.bs.modal', function () {
		location.reload();
		
	});
	
	$('#scriptStatusAcceptDomain').on('hidden.bs.modal', function () {
		location.reload();
		
	});

	$('#VideoStatusAccept').on('hidden.bs.modal', function () {
		location.reload();
		
	});
	
	$('.nav-item').on('click', function () {
		localStorage.setItem('msg', "");
		$( '.approve-success-msg' ).text( localStorage.getItem('msg') );
	});
	
	
	
	//Contributor
	
	// here is code for keyword review
	$('#keywordModale').on('hidden.bs.modal', function () {
		location.reload();
		
	});
	
	// here is  code for 
	$('#exampleModal').on('hidden.bs.modal', function () {
		location.reload();
		
	});
	
	// here is code for Script
	$('#scriptModale').on('hidden.bs.modal', function () {
		location.reload();
		
		
	});
	
	
	// Here  is code for 
	$('#slideModale').on('hidden.bs.modal', function () {
		location.reload();
		
		
	});
	
	
	$('#videoModel').on('hidden.bs.modal', function () {
		location.reload();
		
	});
	
	
	//Admin
	
	$('#VideoStatusAccept').on('hidden.bs.modal', function () {
		location.reload();
		
	});
	
	//Quality
	
	$('#OutlineAccepOrNeedToImprovementQuality').on('hidden.bs.modal', function () {
		location.reload();
		
	});
	

	$('#scriptStatusAccept').on('hidden.bs.modal', function () {
		location.reload();
		
	});
	

	$('#slideAcceptOrNeedImp').on('hidden.bs.modal', function () {
		location.reload();
		
	});
	
	$('#VideoAccepOrNeedToImprovementQuality').on('hidden.bs.modal', function () {
		location.reload();
		
	});
	
	
	$('#keywordAccepOrNeedToImprovementQuality').on('hidden.bs.modal', function () {
		location.reload();
		
	});
	
	$('#categoryNameList').change( function (){
		
		
	});
	
	// Here is code for category display into category and language 
	
	$('#categoryId').change( function () 
	{			
		var categoryid=$("#categoryNameList").val();
		var languageid=$("#inputLanguageList").val();

		$.ajax({
				
	   		  	 type: "GET",
	       		 url: "/loadCategoryAndLanguage",
	       		 data: { "id": categoryid,"lanid": language},
	       		 contentType: "application/json",
	       		 success: function (result){
	       			 
	       		
	       		  var html = '';
		            var len = result.length;
		            html += '<option value="0">Select language</option>';
		            for (var i = 0; i < len; i++) {
		            	
		             html += '<option value="' + result[i] + '">'
		               + result[i]
		               + '</option>';
		            }
		            html += '</option>';
		            
		            $("#inputLanguageList").prop('disabled',false);
		            $('#inputLanguageList').html(html);
		            
					},
					
						error : function(err){
					console.log("not working. ERROR: "+JSON.stringify(err));
				}
				
				
			});
		
	});
	
	$('#categoryname').change(function()
	{
		
  					var catgoryid=$(this).find(":selected").val();
  					$.ajax({
  						
  					  	type: "GET",
  			       		 url: "/loadByCategoryTuturial",
  			       		 data: { "id": catgoryid},
  			       		 contentType: "application/json",
  			       		 success: function (result){
  			       			 
  			       		
  			       		  var html = '';
  	  			            var len = result.length;
  	  			            html += '<option value="0">Select language</option>';
  	  			            for (var i = 0; i < len; i++) {
	  			            	
  	  			             html += '<option value="' + result[i] + '">'
  	  			               + result[i]
  	  			               + '</option>';
  	  			            }
  	  			            html += '</option>';
  	  			            
  	  			            $("#inputLanguage").prop('disabled',false);
  	  			            $('#inputLanguage').html(html);
  	  			            
  	  						},
	 						error : function(err){
	  						console.log("not working. ERROR: "+JSON.stringify(err));
 						}
  						
  						
  					});
  			
  				  
  				});

			/*here we write code for calling Topic*/


		$('#categoryId').change(function(){
  					
  					var catgoryid=$(this).find(":selected").val();
  					$.ajax({
  					  	type: "GET",
  			       		 url: "/loadByCategoryTuturialTopic",
  			       		 data: { "id": catgoryid},
  			       		 contentType: "application/json",
  			       		 success: function (result){
  			       			 
  			       		
  			       		  var html = '';
  	  			            var len = result.length;
  	  			            html += '<option value="0">Select Topic</option>';
  	  			            for (var i = 0; i < len; i++) {
  	  			             html += '<option value="' + result[i] + '">'
  	  			               + result[i]
  	  			               + '</option>';
  	  			            }
  	  			            html += '</option>';
  	  			            
  	  			            $("#inputTopic").prop('disabled',false);
  	  			            $('#inputTopic').html(html);
  	  			            
  	  						},
	  						
	 							error : function(err){
	  						console.log("not working. ERROR: "+JSON.stringify(err));
 						}
	
  					});
  					
  				 
  				  
  				});
	
		
		
		/*here we write code for calling language*/

		$('#categoryId').change(function(){
				
  					var catgoryid=$(this).find(":selected").val();		
  					$.ajax({
  						
  					  	type: "GET",
  			       		 url: "/loadByCategoryTuturial",
  			       		 data: { "id": catgoryid},
  			       		 contentType: "application/json",
  			       		 success: function (result){
  			       			 
  			       		
  			       		  var html = '';
  	  			            var len = result.length;
  	  			            html += '<option value="0">Select language</option>';
  	  			            for (var i = 0; i < len; i++) {
  	  			             html += '<option value="' + result[i] + '">'
  	  			               + result[i]
  	  			               + '</option>';
  	  			            }
  	  			            html += '</option>';
  	  			            
  	  			            $("#inputLanguage").prop('disabled',false);
  	  			            $('#inputLanguage').html(html);
  	  			            
  	  						},
	  						
	 							error : function(err){
	  						console.log("not working. ERROR: "+JSON.stringify(err));
 						}
	
  					});
  					
  				 
  				  
  				}); 	


		
		$('#catId').change(function(){
			
		
				var catgoryid=$(this).find(":selected").val();
				$.ajax({
				  	type: "GET",
		       		 url: "/loadByCategoryTuturial",
		       		 data: { "id": catgoryid},
		       		 contentType: "application/json",
		       		 success: function (result){
		       			 
		       		
		       		  var html = '';
			            var len = result.length;
			            html += '<option value="0">Select Topic</option>';
			            for (var i = 0; i < len; i++) {
			             html += '<option value="' + result[i] + '">'
			               + result[i]
			               + '</option>';
			            }
			            html += '</option>';
			            
			            $("#inputLanguage1").prop('disabled',false);
			            $('#inputLanguage1').html(html);

						},
						
						
						error : function(err){
						console.log("not working. ERROR: "+JSON.stringify(err));
					}
					
					
				});
		
			  
			});
				
		
	/*	here is code for download question*/
		
		
		$('#inputLanguage1').change(function(){
					

				var catgoryid=$(this).find(":selected").val();
				
				$.ajax({	
				  	type: "GET",
		       		 url: "/downloadQuestion",
		       		 data: { "id": catgoryid},
		       		 contentType: "application/json",
		       		 success: function (result){
		       			 
		       		
		       		  var html = '';
			            var len = result.length;
			            html += '<a href="#">Click To Open</a>';
			            for (var i = 0; i < len; i++) {
			            	
			            	
			             html +='<a her="' + result[i] + '">'
			               +'<a href='+ result[i]+'>'+result[i]+'</a>'   + '</option>';
		             
			         
			            }
			            html += '</option>';
			            
			            $("#input").prop('disabled',false);
			            
			            $('#inputdiv').html(html);
			            

						},
						
						
						error : function(err){
						console.log("not working. ERROR: "+JSON.stringify(err));

					}
					
					
				});
		
			  
			});	
		
		
		
		/*
					master trainer depending on language wet topic*/
		
		$('#inputLanguage').change(function(){
		  				
		  					var catgoryid=$(this).find(":selected").val();
		  					
		  					$.ajax({
		  					  	type: "GET",
		  			       		 url: "/loadByLangugaeTopic",
		  			       		 data: { "id": catgoryid},
		  			       		 contentType: "application/json",
		  			       		 success: function (result){
		  			       			 
		  			       		
		  			       		  var html = '';
		  	  			            var len = result.length;
		  	  			            html += '<option value="0">Select Topic</option>';
		  	  			            for (var i = 0; i < len; i++) {
			  			            	
		  	  			             html += '<option value="' + result[i] + '">'
		  	  			               + result[i]
		  	  			               + '</option>';
		  	  			            }
		  	  			            html += '</option>';
		  	  			            
		  	  			            $("#selectLanguageId").prop('disabled',false);
		  	  			            $('#selectLanguageId').html(html);
		  	  			            
		  	  						},
			  						
			 							error : function(err){
			  						console.log("not working. ERROR: "+JSON.stringify(err));
		 						}
			
		  					});
		  							  
		  				});
		
		//chages according to individual  table by languge 
		
		$('#catId').change(function(){
			
			var catgoryid=$(this).find(":selected").val();
				
				$.ajax({
				  	type: "GET",
		       		 url: "/loadBycategorylanguage",
		       		 data: { "id": catgoryid},
		       		 contentType: "application/json",
		       		 success: function (result){
		       			 
		       		
		       		  var html = '';
			            var len = result.length;
			            html += '<option value="0">Select language</option>';
			            for (var i = 0; i < len; i++) {
			            	
			             html += '<option value="' + result[i] + '">'
			               + result[i]
			               + '</option>';
			            }
			            html += '</option>';
			            
			            $("#inputLan").prop('disabled',false);
			            $('#inputLan').html(html);
			            
						},
						
							error : function(err){
						console.log("not working. ERROR: "+JSON.stringify(err));
					}
					
					
				});
		
			  
			});
		

		/* Access topic according to langaueg*/
		
		$('#MasterCategoryId').change(function(){
			
		
				var catgoryid=$(this).find(":selected").val();
				$.ajax({
					
				  	type: "GET",
		       		 url: "/loadByCategoryByTopic",
		       		 data: { "id": catgoryid},
		       		 contentType: "application/json",
		       		 success: function (result){
		       			 
		       		
		       		  var html = '';
			            var len = result.length;
			            html += '<option value="0">Select Topic</option>';
			            for (var i = 0; i < len; i++) {
			             html += '<option value="' + result[i] + '">'
			               + result[i]
			               + '</option>';
			            }
			            html += '</option>';
			            
			            $("#inputTopic").prop('disabled',false);
			            $('#inputTopic').html(html);
			            
						},
						
							error : function(err){
						console.log("not working. ERROR: "+JSON.stringify(err));
					}

				});
				
			 
			  
			});
				
		/*load Topic by catgory contributor*/
		
		$('#categoryContributor').change(function(){
		
			var catgoryid=$(this).find(":selected").val();
				
			$.ajax({
					
				  	type: "GET",
		       		 url: "/loadTopicByCategoryContributor",
		       		 data: { "id": catgoryid},
		       		 contentType: "application/json",
		       		 success: function (result){

			             html += '<option value="' + result[i] + '">'
			               + result[i]
			               + '</option>';
			            
		       		
		       		  var html = '';
			            var len = result.length;
			            html += '<option value="0">Select Topic</option>';
			            for (var i = 0; i < len; i++) {
			             html += '<option value="' + result[i] + '">'
			               + result[i]
			               + '</option>';
			            }
			            html += '</option>';
			            
			            $("#inputTopicContributor").prop('disabled',false);
			            $('#inputTopicContributor').html(html);
			            
						},
						
							error : function(err){
						console.log("not working. ERROR: "+JSON.stringify(err));
					}

				});
			  
			});
		
		/*contributor languages*/
		
		$('#inputTopicContributor').change(function(){
	
			var catgoryid=$(this).find(":selected").val();
				$.ajax({
					
				  	type: "GET",
		       		 url: "/loadLanguageByTopicId",
		       		 data: { "id": catgoryid},
		       		 contentType: "application/json",
		       		 success: function (result){
		       		
		       		  var html = '';
			            var len = result.length;
			            html += '<option value="0">Select Topic</option>';
			            for (var i = 0; i < len; i++) {
			             html += '<option value="' + result[i] + '">'
			               + result[i]
			               + '</option>';
			            }
			            html += '</option>';
			            
			            $("#inputLanguageContributor").prop('disabled',false);
			            $('#inputLanguageContributor').html(html);
			            
						},
						
							error : function(err){
						console.log("not working. ERROR: "+JSON.stringify(err));
					}

				});
				
			 
			  
			});
		
		
		/*
		Access language depending on topic contributer*/
		
		$('#inputTopic').change(function(){
			
				var catgoryid=$(this).find(":selected").val();
				$.ajax({
				  	type: "GET",
		       		 url: "/loadlanguage",
		       		 data: { "id": catgoryid},
		       		 contentType: "application/json",
		       		 success: function (result){
		       			 
		       		
		       		  var html = '';
			            var len = result.length;
			            html += '<option value="0">Select Languge</option>';
			            for (var i = 0; i < len; i++) {
			             html += '<option value="' + result[i] + '">'
			               + result[i]
			               + '</option>';
			            }
			            html += '</option>';
			            
			            $("#inputLanguage").prop('disabled',false);
			            $('#inputLanguage').html(html);
			            
						},
						
							error : function(err){
						console.log("not working. ERROR: "+JSON.stringify(err));
						
						
					}

				});
		  
			});
		
		
		$('#outlineId').click(function()	
		{
		
			var saveInfo=editor.getData();
			var keywordArea=$("#keyword").val();
			var categoryid=$("#categoryId").val();
			var topicid=$("#topicId").val();
			var lanId=$("#lanId").val();

			$.ajax({
			  	type: "GET",
	       		 url: "/outline",	
	       		 data: { "saveOutline": saveInfo,"id": keywordArea,"categorname" : categoryid,"topicid":topicid,"lanId":lanId},
	       		 contentType: "application/json",
	       		 success: function(result)
	       		 {
	       			 
	       			 alert("Successfully Save Data");
	       			 
	       			 $("#statusOutline").prop('disabled',false);
	       			 $('#statusOutline').html(html);
	       			
	       		
					},		
						error : function(err){
					console.log("not working. ERROR: "+JSON.stringify(err));
				}

			});
  
		});
		
		/*Save keyWord information into table*/
		
	
		$('#keywordId').click(function()			
		{
				
				var keywordArea=$("#keyword").val();
				var categoryid=$("#categoryId").val();
				var topicid=$("#topicId").val();
				var lanId=$("#lanId").val();
			
				$.ajax({
					  	type: "GET",
			       		 url: "/keyword",
			       		 data: { "id": keywordArea,"categorname" : categoryid,"topicid":topicid,"lanId":lanId },			
			       		 contentType: "application/json",
			       		 success: function(result)
			       		 {
			     
			       			 $("#statuskeyword").prop('disabled',false);
			       			 $('#statuskeyword').html(result);
			       		
							},
							
								error : function(err){
							console.log("not working. ERROR: "+JSON.stringify(err));
						}

					});
		  
				});
		
		/*
		Here is code for save script*/
		
		
		$('#scriptId').click(function()	
		{
		
			

					
							var categoryid=$("#categoryId").val();
							var topicid=$("#topicId").val();
							var lanId=$("#lanId").val();
							
							
							var form = $('#upload-file-form-script')[0]; 
							var formData = new FormData(form); 
		
						
							formData.append('categoryid', categoryid);
							formData.append('topicid', topicid);
							formData.append('lanId', lanId);	
							
					
							
							$.ajax({
								
								type: "POST",
							    url: "/scriptUpload",
							    data: formData,
							    enctype: 'multipart/form-data',
							    processData: false,
							    contentType: false,
							    cache: false,
							    success: function (result)
							{
								    	
							
						       			 $("#statusofScript").prop('disabled',true);
						       			 $('#statusofScript').html(result);				       								
							 },
						
							error : function(err){
						console.log("not working. ERROR: "+JSON.stringify(err));
					}
							 
				});
	  
			});
		
		
		
		
		/*here we write  code for slide 
		*/
		

			$('#slideId').click(function()	
			{
		
						var categoryid=$("#categoryId").val();
						var topicid=$("#topicId").val();
						var lanId=$("#lanId").val();
						
						
						var form = $('#upload-file-form')[0]; 
						var formData = new FormData(form); 
	
					
						formData.append('categoryid', categoryid);
						formData.append('topicid', topicid);
						formData.append('lanId', lanId);

						$.ajax({
							    type: "POST",
							    url: "/slideUpload",
							    data: formData,
							    enctype: 'multipart/form-data',
							    processData: false,
							    contentType: false,
							    cache: false,
							    success: function (result)
							    {
							    	
					    
					       			 $("#statusofSlide").prop('disabled',true);
					       			 $('#statusofSlide').html(result);				       		
					
							    },
					
						error : function(err){
					console.log("not working. ERROR: "+JSON.stringify(err));
				}
							    
			});
  
		});
			
	/*		video for thumnail and video*/
			
			
	$('#videoId').click(function()	
		{
				
								var categoryid=$("#categoryId").val();
								var topicid=$("#topicId").val();
								var lanId=$("#lanId").val();
								
								
								var form = $('#upload-file-form-video')[0]; 
								var formData = new FormData(form); 
			
							
								formData.append('categoryid', categoryid);
								formData.append('topicid', topicid);
								formData.append('lanId', lanId);
			
				$.ajax({
									    type: "POST",
									    url: "/videoUpload",
									    data: formData,
									    enctype: 'multipart/form-data',
									    processData: false,
									    contentType: false,
									    cache: false,
									    success: function (result)
									    {
									    	
							    
							       			 $("#statusofVideo").prop('disabled',true);
							       			 $('#statusofVideo').html(result);				       		
							       			 
									    },
							
								error : function(err){
							console.log("not working. ERROR: "+JSON.stringify(err));
						}

					});
		  
				});
	
	
	$('#PrerequisiteVideoId').click(function()	
	{
				
								var categoryid=$("#categoryId").val();
								var topicid=$("#topicId").val();
								var lanId=$("#lanId").val();
								
								
								var form = $('#upload-file-form-prerequisite')[0]; 
								var formData = new FormData(form); 
			
							
								formData.append('categoryid', categoryid);
								formData.append('topicid', topicid);
								formData.append('lanId', lanId);
				
							$.ajax({
									    type: "POST",
									    url: "/prerequisite",
									    data: formData,
									    enctype: 'multipart/form-data',
									    processData: false,
									    contentType: false,
									    cache: false,
									    success: function (result)
									    {
									    	
							    
							       			 $("#statusofprerequisite").prop('disabled',true);
							       			 $('#statusofprerequisite').html(result);				       		
							       			 
									    },
							
								error : function(err){
							console.log("not working. ERROR: "+JSON.stringify(err));
						}

					});
		  
				});
	
	
			
			
			
	$('#myCheck').click(function()			 
	{
				
		var checkbox=$("#myCheck").val();
			
				$.ajax({
					
					  	type: "GET",
			       		 url: "/keyword",
			       		 data: { "id": keywordArea },			
			       		 contentType: "application/json",
			       		 success: function(result)
			       		 {
			       			 $("#statuskeyword").prop('disabled',false);
			       			 $('#statuskeyword').html(result);
			       		
							},
							
								error : function(err){
							console.log("not working. ERROR: "+JSON.stringify(err));
						}

					});
		  
				});
	
	/*here  calling approve button for contributorvideoUpload */
	
	$('.approveContributor').click(function()			
	{
//				use localStorage to retrieve information on page refresh
				localStorage.setItem('activeTab', "Contributer");
				
				
				var contributionId=$(this).val();
				
						$.ajax({
							  	type: "GET",
					       		 url: "/addContributerRoleById",
					       		 data: { "id": contributionId},			
					       		 contentType: "application/json",
					       		 success: function(result)
					       		{

				       			 $("#statusContributor").prop('disabled',false);
//				       			 $('#statusContributor').html(result);
				       			 
				       			localStorage.setItem('msg', result);
//				       		$('#ContributerPage').on('hidden.bs.modal', function () 
//				    		  {
//				       			
//				       				location.reload();
//				       				
//				       				
//				       			});  			 
				       			 
				       			 
				       		location.reload();
				       		
				       		
					       		},
										
									error : function(err){
									console.lo3g("not working. ERROR: "+JSON.stringify(err));
								}

							});
						
						
				  
			});
	
	// Here is code for  Admin Reviwer  Approve

	$('.approveAdmin').click(function()			
	{
//		use localStorage to retrieve information on page refresh
		localStorage.setItem('activeTab', "Admin");
				var contributionId=$(this).val();
				
				$.ajax({
							  	 type: "GET",
					       		 url: "/addAdminRoleById",
					       		 data: { "id": contributionId},			
					       		 contentType: "application/json",
					       		 success: function(result)
					       		{

				       			 $("#statusAdmin").prop('disabled',false);
//				       			 $('#statusAdmin').html(result);
				       			localStorage.setItem('msg', result);
				       			 
				       			 
				       		$('#ContributerPage').on('hidden.bs.modal', function () 
				    		  {
				       			
				       				location.reload();
				       				
				       			});  			 
				       			 
				       		location.reload();
					       	
					       		},
										
									error : function(err){
									console.lo3g("not working. ERROR: "+JSON.stringify(err));
								}

							});
						
						
				  
			});
	
	// Here is code for Quality Reviweer
	
	$('.approveQuality').click(function()			
			{
				//		use localStorage to retrieve information on page refresh
						localStorage.setItem('activeTab', "Quality");
						var contributionId=$(this).val();
						
						$.ajax({
									  	 type: "GET",
							       		 url: "/addQualityRoleById",
							       		 data: { "id": contributionId},			
							       		 contentType: "application/json",
							       		 success: function(result)
							       		{

						       			 $("#statusQuality").prop('disabled',false);
						       			 $('#statusQuality').html(result);
						       			localStorage.setItem('msg', result);
						       			 
						       		$('#ContributerPage').on('hidden.bs.modal', function () 
						    		  {
						       			
						       				location.reload();
						       				
						       			});  			 
						       			 
						       		location.reload();
							       	
							       		},
												
											error : function(err){
											console.lo3g("not working. ERROR: "+JSON.stringify(err));
										}

									});
								
								
						  
					});


	// Here is code for Master Trainer
	
	$('.approvemaster').click(function()			
		{
		//		use localStorage to retrieve information on page refresh
				localStorage.setItem('activeTab', "MasterTrainer");
				
						var contributionId=$(this).val();
						
						$.ajax({
									  	 type: "GET",
							       		 url: "/addMasterRoleById",
							       		 data: { "id": contributionId},			
							       		 contentType: "application/json",
							       		 success: function(result)
							       		{

						       			 $("#statusMaster").prop('disabled',false);
						       			 $('#statusMaster').html(result);
						       			localStorage.setItem('msg', result);
						       			 
						       		$('#ContributerPage').on('hidden.bs.modal', function () 
						    		  {
						       			
						       				location.reload();
						       				
						       			});  			 
						       			 
						       		location.reload();
							       	
							       		},
												
											error : function(err){
											console.lo3g("not working. ERROR: "+JSON.stringify(err));
										}

									});
								
								
						  
					});
	
	
	
	
	
// here is code for approve DomainReviwer By admin
	
	
	

	$('.approveDomain').click(function()			
	{
		//		use localStorage to retrieve information on page refresh
		localStorage.setItem('activeTab', "Domain");
		
				var contributionId=$(this).val();
				
				$.ajax({
							  	 type: "GET",
					       		 url: "/addDomainRoleById",
					       		 data: { "id": contributionId},			
					       		 contentType: "application/json",
					       		 success: function(result)
					       		{

				       			 $("#statusDomain").prop('disabled',false);
				       			 $('#statusDomain').html(result);
				       			localStorage.setItem('msg', result);
				       			 
				       		$('#ContributerPage').on('hidden.bs.modal', function () 
				    		  {
				       			
				       				location.reload();
				       				
				       			});  			 
				       			 
				       		location.reload();
					       	
					       		},
										
									error : function(err){
									console.lo3g("not working. ERROR: "+JSON.stringify(err));
								}

							});
						
						
				  
			});

	
	
	$('#rejectContributionId').click(function()			
			{
	
						var contributionId=$("#contributorId").val();
						
								$.ajax({
									  	type: "GET",
							       		 url: "/rejectContributorById",
							       		 data: { "id": contributionId},			
							       		 contentType: "application/json",
							       		 success: function(result)
							       		{

					       			 $("#statusContributor").prop('disabled',false);
					       			 $('#statusContributor').html(result);
						       	
									},
												
											error : function(err){
											console.log("not working. ERROR: "+JSON.stringify(err));
										}

									});
						  
					});
			
			/*load By Contributor user only //Contributor assign from 	*/
	
	
			$('#contributorId').click(function()			
			{	
				
				var userContributor=$(this).find(':selected').val();

								$.ajax({
									type: "GET",
						       		 url: "/loadLanguageByUser",
						       		 data: { "id": userContributor},
						       		 contentType: "application/json",
						       		 success: function (result){
		
						       			
						       			 var html = '';
						       			 var len = result.length;
							             html += '<option value="0">Select Language</option>';
							             for (var i = 0; i < len; i++) {
							             html += '<option value="' + result[i] + '">'
							               + result[i]
							               + '</option>';
							             }
							             html += '</option>';
							            
							            $("#lanId").prop('disabled',false);
							            $('#lanId').html(html);
							            
										},
										
										error : function(err){
											console.log("not working. ERROR: "+JSON.stringify(err));
										}
									});
								
								
							
				});
				
			
			
	$('#lanId').click(function()			
	{			
							var languageName=$("#lanId :selected").text();
					
								$.ajax({
											type: "GET",
								       		 url: "/loadCategoryByLanguage",
								       		 data: { "id": languageName},
								       		 contentType: "application/json",
								       		 success: function (result){
				
								       			 	
								       			 var html = '';
								       			 var len = result.length;
									             html += '<option value="0">Select Category</option>';
									             for (var i = 0; i < len; i++) {
									             html += '<option value="' + result[i] + '">'
									               + result[i]
									               + '</option>';
									             }
									             html += '</option>';
									            
									            $("#catgoryByContributor").prop('disabled',false);
									            $('#catgoryByContributor').html(html);
									            
												},
												
												error : function(err){
													console.log("not working. ERROR: "+JSON.stringify(err));
												}
											});
								  
						});	
					
						$('#catgoryByContributor').click(function()			
						{			
								var category=$(this).find("option:selected").val();
	
									$.ajax({
													 type: "GET",
										       		 url: "/loadTopicByCategory",
										       		 data: { "id": category },
										       		 contentType: "application/json",
										       		 success: function (result){
						
										       			 1	
										       			 var html = '';
										       			 var len = result.length;
											             html += '<option value="0">Select Topic</option>';
											             for (var i = 0; i < len; i++) {
											             html += '<option value="' + result[i] + '">'
											               + result[i]
											               + '</option>';
											             }
											             html += '</option>';
											            
											            $("#inputTopic").prop('disabled',false);
											            $('#inputTopic').html(html);
											            
														},	
														error : function(err){
															console.log("not working. ERROR: "+JSON.stringify(err));
														}
													});
										  
								});
			
	
						//here write code for keyword view	//add content form
						
						$('#keywordModaleView').click(function()			
								{
												
												var categoryid=$("#categoryId").val();
												var topicid=$("#topicId").val();
												var lanId=$("#lanId").val();
												
												$.ajax({
													  	type: "GET",
											       		 url: "/viewKeyword",
											       		 data: { "categorname" : categoryid,"topicid":topicid,"lanId":lanId },			
											       		 contentType: "application/json",
											       		 success: function(result)
											       		 {

											       			 
											       			 $("#keywordView").prop('disabled',false);
											       			 $('#keywordView').html(result);
											       		
															},
															
																error : function(err){
															console.log("not working. ERROR: "+JSON.stringify(err));
														}
								
													});
										  
												});
					
				// Here is Code for Quality	Review keyword View
						
			$('#keywordModaleViewInQuality').click(function()			
			{
			
												var categoryid=$("#categoryId").val();
												var topicid=$("#topicId").val();
												var lanId=$("#lanId").val();
												
												$.ajax({
													  	type: "GET",
											       		 url: "/viewKeywordInQuality",
											       		 data: { "categorname" : categoryid,"topicid":topicid,"lanId":lanId },			
											       		 contentType: "application/json",
											       		 success: function(result)
											       		 { 
											       			
											       			 
											       			 $("#keywordViewInKeyword").prop('disabled',false);
											       			 $('#keywordViewInKeyword').html(result);
											       		
															},
															
																error : function(err){
															console.log("not working. ERROR: "+JSON.stringify(err));
														}
								
													});
										  
												});
						
			/*Here code to view keywored into Domain reviwer*/
			
			$('#keywordModaleViewInDomain').click(function()			
			{
				
				
														var categoryid=$("#categoryId").val();
														var topicid=$("#topicId").val();
														var lanId=$("#lanId").val();
														
														
														$.ajax({
															  	type: "GET",
													       		 url: "/viewKeywordInDomain",
													       		 data: { "categorname" : categoryid,"topicid":topicid,"lanId":lanId },			
													       		 contentType: "application/json",
													       		 success: function(result)
													       		 { 
													       			
													       			 $('#keywordViewInDomainKeyword').html(result);
													       		
																	},
																	
																		error : function(err){
																	console.log("not working. ERROR: "+JSON.stringify(err));
																}
										
															});
												  
			});
			
			
			
			
			
			
						
				$('#videoViewId').click(function()			
				{
							
					
							
												var categoryid=$("#categoryId").val();
												var topicid=$("#topicId").val();
												var lanId=$("#lanId").val();
												
												$.ajax({
													
													  	type: "GET",
											       		 url: "/viewVideo",
											       		 data: { "categorname" : categoryid,"topicid":topicid,"lanId":lanId },		
											       		 contentType: "application/json",
											       		 success: function(result)
											       		 {
											       					 
											       			
											       			 //$("#VideoView").prop('disabled',false);
											       			 //$('#VideoView').html(result);
											       			
											       		        var res =  result;
											       		      
											       		        source =  document.getElementById('storedVideoId');
											       		        source.setAttribute('src',res);
											       		        source.setAttribute('type','video/mp4')

											       		        source.play(); //test playback of new video
											       		        
											       		       // $('#videoDiv').show()
											       		   
											       		
															},
															
																error : function(err){
															console.log("not working. ERROR: "+JSON.stringify(err));
														}
								
													});
										  
												});
						
					
				// here is code for Quality View
				
				
				$('#videoViewId').click(function()			
				{
							
					
							
												var categoryid=$("#categoryId").val();
												var topicid=$("#topicId").val();
												var lanId=$("#lanId").val();
												
												$.ajax({
													
													  	type: "GET",
											       		 url: "/viewVideo",
											       		 data: { "categorname" : categoryid,"topicid":topicid,"lanId":lanId },		
											       		 contentType: "application/json",
											       		 success: function(result)
											       		 {
											       					 
											       			
											       			 //$("#VideoView").prop('disabled',false);
											       			 //$('#VideoView').html(result);
											       			
											       		        var res =  result;
											       		      
											       		        source =  document.getElementById('storedVideoId');
											       		        source.setAttribute('src',res);
											       		        source.setAttribute('type','video/mp4')

											       		        source.play(); //test playback of new video
											       		        
											       		       // $('#videoDiv').show()
											       		   
											       		
															},
															
																error : function(err){
															console.log("not working. ERROR: "+JSON.stringify(err));
														}
								
													});
										  
												});
				
				
				
			
				
				
				
				
						//here code outline View
						
						$('#outlineViewModel').click(function()			
						{
							
												var categoryid=$("#categoryId").val();
												var topicid=$("#topicId").val();
												var lanId=$("#lanId").val();
												$.ajax({
													
													  	type: "GET",
											       		 url: "/outlineView",
											       		 data: { "categorname" : categoryid,"topicid":topicid,"lanId":lanId },		
											       		 contentType: "application/json",
											       		 success: function(result)
											       		 {
											       			 
											       			 $("#outlineViewResponse").prop('disabled',false);
											       			 $('#outlineViewResponse').html(result);
											       		
															},
															
																error : function(err){
															console.log("not working. ERROR: "+JSON.stringify(err));
														}
								
													});
										  
												});
						
						//Script View  Contributor
						
					
						$('#viewScriptId').click(function()			
						{
							
											
																var categoryid=$("#categoryId").val();
																var topicid=$("#topicId").val();
																var lanId=$("#lanId").val();
																$.ajax({
																	
																	  	type: "GET",
															       		 url: "/scriptPdf",
															       		 data: { "categorname" : categoryid,"topicid":topicid,"lanId":lanId },		
															       		 contentType: "application/json",
															       		 success: function(result)
															       		 {
															       		 	var res =  result;
															       		       //alert("NEW video path : " + res); //should be a valid path eg: https://example.com/myvideo.mp4

															       		        source =  document.getElementById('ScriptPdf');
															       		        source.setAttribute('href',res);
															       		        
															       		       // source.setAttribute('type','video/mp4')
															       		        source.play(); 
															       			 
															      
																			},
																			
																				error : function(err){
																			console.log("not working. ERROR: "+JSON.stringify(err));
																		}
												
																	});
														  
																});
						
						
						//Contributor Script modelView
						
							$('#slideModaleView').click(function()			
								{
											
																var categoryid=$("#categoryId").val();
																var topicid=$("#topicId").val();
																var lanId=$("#lanId").val();
																$.ajax({
																	
																	  	type: "GET",
															       		 url: "/sliedPdf",
															       		 data: { "categorname" : categoryid,"topicid":topicid,"lanId":lanId },		
															       		 contentType: "application/json",
															       		 success: function(result)
															       		 {
															       		 	var res =  result;
															       		      //  alert("NEW video path : " + res); //should be a valid path eg: https://example.com/myvideo.mp4

															       		        source =  document.getElementById('sliedPdf');
															       		        source.setAttribute('href',res);
															       		       // source.setAttribute('type','video/mp4')

															       		        source.play(); 
															       			 
															      
																			},
																			
																				error : function(err){
																			console.log("not working. ERROR: "+JSON.stringify(err));
																		}
												
																	});
														  
																});
							
				// here is code for keyword accept or need to improvement
							
							
							
					$('#AcceptOrNeedToImprovemenetByDomain').click(function()
						{
									
										var categoryid=$("#categoryId").val();
										var topicid=$("#topicId").val();
										var lanId=$("#lanId").val();
									
										var vals=$("#KeywordAcceptDomain").val();	
										
										
										 if(vals === '0'){
											 
											 
										 $('#keywordNeedImprovement').css({'visibility':'hidden'});  
											  
											  alert("Select Accept Or Need To Improvement");  
											  
											
										 }
										 else if(vals === '1'){
											 
											  $('#keywordNeedImprovement').css({'visibility':'hidden'}); 
											  
											  		alert("Hello");		
											  		
											  		
												$.ajax({
													
												  	type: "GET",
										       		 url: "/acceptkeywordByDomain",
										    		 data: { "categorname" : categoryid,"topicid":topicid,"lanId":lanId },		
										       		 contentType: "application/json",
										       		 success: function(result)
										       		{
										       			 
									       			 $("#statusKeywordByDomain").prop('disabled',false);
									       			 $('#statusKeywordByDomain').html(result);
										       	
										       		},
															
														error : function(err){
														console.lo3g("not working. ERROR: "+JSON.stringify(err));
													}

												});	 
											  
											  
											 
										 }else if ( vals === '2') {
											
											 $('#keywordNeedImprovement').css({'visibility':'visible'});
											 
											 var msg=$("#keywordCommentMsg").val();
											 
										
											 
												$.ajax({
													
												  	type: "GET",
										       		 url: "/needToImpKeywordByDomain",
										    		 data: { "categorname" : categoryid,"topicid":topicid,"lanId":lanId,'msg':msg},		
										       		 contentType: "application/json",
										       		 success: function(result)
										       		{
										       			 
									       			 $("#statusKeywordByDomain").prop('disabled',false);
									       			 $('#statusKeywordByDomain').html(result);
										       	
										       		},
															
														error : function(err){
														console.lo3g("not working. ERROR: "+JSON.stringify(err));
													}

												});	 
											 
										 			
										 
										 
										 }
										
											});

							
							
							
							
							
							
							
							
							
							//Display  comment box for need to improvemnet on outline
							
							$('#outlineAcceptOtrNeedImp').click(function()			
								{
								
										
										var vals=$("#outlineAcceptOtrNeedImp").val();
										
										 if(vals === '0'){
											 
											  $('#OutlineNeedImp').css({'visibility':'hidden'});         
						 		          
										 }
										 else if(vals === '1'){
											 
											  $('#OutlineNeedImp').css({'visibility':'hidden'}); 
											 
										 }else if ( vals === '2') {
											
											 $('#OutlineNeedImp').css({'visibility':'visible'});
										}
										
											  
									});
							
							
							
					$('#outlineAcceptOrNeedToImpClick').click(function()
					{
								
						
						var categoryid=$("#categoryId").val();
						var topicid=$("#topicId").val();
						var lanId=$("#lanId").val();
					
						
						var vals=$("#outlineAcceptOtrNeedImp").val();	
						
						
						 if(vals === '0'){
							 
							 
						 $('#OutlineNeedImp').css({'visibility':'hidden'});  
							  
							  alert("Select Accept Or Need To Improvement");  
							  
							
						 }
						 else if(vals === '1'){
							 
							  $('#OutlineNeedImp').css({'visibility':'hidden'}); 
							  
							  
								$.ajax({
									
								  	type: "GET",
						       		 url: "/acceptOutlineByDomain",
						    		 data: { "categorname" : categoryid,"topicid":topicid,"lanId":lanId },		
						       		 contentType: "application/json",
						       		 success: function(result)
						       		{
						       			 
					       			 $("#statusOutlineByDomain").prop('disabled',false);
					       			 $('#statusOutlineByDomain').html(result);
						       	
						       		},
											
										error : function(err){
										console.lo3g("not working. ERROR: "+JSON.stringify(err));
									}

								});	 
							  
							  
							 
						 }else if ( vals === '2') {
							
							 $('#OutlineNeedImp').css({'visibility':'visible'});
							 
							 var msg=$("#msgCommentOutline").val();
							 
							 
							 
								$.ajax({
									
								  	type: "GET",
						       		 url: "/needToImpOutlineByDomain",
						    		 data: { "categorname" : categoryid,"topicid":topicid,"lanId":lanId,'msg':msg},		
						       		 contentType: "application/json",
						       		 success: function(result)
						       		{
						       			 
					       			 $("#statusOutlineByDomain").prop('disabled',false);
					       			 $('#statusOutlineByDomain').html(result);
						       	
						       		},
											
										error : function(err){
										console.lo3g("not working. ERROR: "+JSON.stringify(err));
									}

								});	 
							 
						 			
						 
						 
						 }
						
							});
							
							
					
					//here is code for Script for domain 
					
							$('#scriptAccept').click(function()			
								{	
								
										var vals=$("#scriptAccept").val();
	
										 if(vals === '0')
										 { 
											  $('#scriptNeedImprovement').css({'visibility':'hidden'});         
						 		          }
										 else if(vals==='1')
										 {
											 
											  $('#scriptNeedImprovement').css({'visibility':'hidden'}); 
											  
											  
										 }else if (vals === '2') {
											 
											 
											  $('#scriptNeedImprovement').css({'visibility':'visible'}); 
											 
											 
											
										}
										 
											  
									});
							
							
							
							$('#VideoAccept').click(function()			
									{
								
											//var vals=$("#VideoAccept").val();
											
											var vals=$(this).find(":selected").val();
		
										
											 if(vals === '0')
											 { 
												  $('#videoNeedImprovement').css({'visibility':'hidden'}); 
												  
							 		          }
											 else if(vals === '1')
											 {
												 
												 $('#videoNeedImprovement').css({'visibility':'visible'}); 											 
												 

											 }
												  
										});
							
						
							
			$('#VideoAcceptAdmin').click(function()			
		{
				
							var vals=$(this).find(":selected").val();
							
							
							 if(vals === '0')
							 { 
								  $('#videoNeedImprovement').css({'visibility':'hidden'}); 
								  
								 
								  
								  
			 		          }
							 else if(vals === '1'){
								 
					
								  $('#videoNeedImprovement').css({'visibility':'hidden'}); 
								  
								  l
								  
								  

							 }
							 else if(vals === '2')
							 {
								 
								 $('#videoNeedImprovement').css({'visibility':'visible'}); 											 
								 

							 }
							 
							 
					});
	
						//Display domain Outline
					
							$('#outlineViewModelDomain').click(function()			
						{
									
								
															var categoryid=$("#categoryId").val();
															var topicid=$("#topicId").val();
															var lanId=$("#lanId").val();
															$.ajax({
																
																  	type: "GET",
														       		 url: "/outlineViewDomain",
														       		 data: { "categorname" : categoryid,"topicid":topicid,"lanId":lanId },		
														       		 contentType: "application/json",
														       		 success: function(result)
														       		 {
														       
													       			 $('#outlineViewResponseDomain').val(result)
													       			
														       		
														       		 },
																		
																			error : function(err){
																		console.log("not working. ERROR: "+JSON.stringify(err));
																	}
											
																});
													  
															});
							
					/*		View Script from domain */
							
							$('#viewScriptIdDomain').click(function()			
						 {
								
													var categoryid=$("#categoryId").val();
													var topicid=$("#topicId").val();
													var lanId=$("#lanId").val();
											
								$.ajax({
																			 type: "get",
																       		 url: "/scriptPdfDomain",
																       		 data: { "categorname" : categoryid,"topicid":topicid,"lanId":lanId },		
																       		 contentType: "application/json",
																       		 success: function(result)
																       		 {
																       			var res = result;
																       			 
																       			
																       			 
																       		        source =  document.getElementById('scriptPdfDomain');
																       		        source.setAttribute('href',res);
																       		       
																				},
																				
																					error : function(err){
																				console.log("not working. ERROR: "+JSON.stringify(err));
																			}
													
																		});
															  
																	});
								
							/*view Video By Domain*/
							
							$('#videoViewIdDomain').click(function()			
						{
											
								
												var categoryid=$("#categoryId").val();
												var topicid=$("#topicId").val();
												var lanId=$("#lanId").val();
																	
											$.ajax({
																		
														type: "GET",
														url: "/viewVideoDomain",
														data: { "categorname" : categoryid,"topicid":topicid,"lanId":lanId },		
														contentType: "application/json",
														success: function(result)
													 {
											       					 
											       		      var res = result;
											       		      
											       		   //  alert("NEW video path : " + res); //should be a valid path eg: https://example.com/myvideo.mp4


											       		        source =  document.getElementById('storedVideoIdDomain');
											       		        source.setAttribute('src', "http://localhost:8081/"+res);
											       		        source.setAttribute('type','video/mp4')

											       		        source.play(); 

											       		        
															},
																												  
																				error : function(err){
																				console.log("not working. ERROR: "+JSON.stringify(err));
																			}
													
																		});
															  
																	});
							
							
							/*Here is code for comment on componenet outline*/
							
								$('#submitCommentId').click(function()			
								{
									
												
																	var categoryid=$("#categoryId").val();
																	var topicid=$("#topicId").val();
																	var lanId=$("#lanId").val();
																	var commentOutlineMsg=$("#msgCommentOutline").val();
																	
																	
																	
																	$.ajax({
																		
																		  	type: "GET",
																       		 url: "/commentOnOutline",
																       		 data: { "categorname" : categoryid,"topicid":topicid,"lanId":lanId,"commentOutlineMsg":commentOutlineMsg,},		
																       		 contentType: "application/json",
																       		 success: function(result)
																       		 {
																       			 $("#saveComment").prop('disabled',false);
																       			 $('#saveComment').html(result);
																       		
																       			 
																				},
																				
																					error : function(err){
																				console.log("not working. ERROR: "+JSON.stringify(err));
																			}
													
																		});
															  
																	});		
							
							
					
					/*Here is code for comment on componenet Video Domain*/
					
					$('#videoAcceptOrNeedToImprovemenet').click(function()			
					{
								
											
																var categoryid=$("#categoryId").val();
																var topicid=$("#topicId").val();
																var lanId=$("#lanId").val();
																var videoCommentMsg=$("#videoCommentMsg").val();
																
																
																
																$.ajax({
																	
																	  	type: "GET",
															       		 url: "/commentOnVideo",
															       		 data: { "categorname" : categoryid,"topicid":topicid,"lanId":lanId,"videoCommentMsg":videoCommentMsg},		
															       		 contentType: "application/json",
															       		 success: function(result)
															       		 {
															       			
															       			
															       			 $("#saveCommentVideo").prop('disabled',false);
															       			 $('#saveCommentVideo').html(result);
															       		
															       			 
																			},
																			
																				error : function(err){
																			console.log("not working. ERROR: "+JSON.stringify(err));
																		}
												
																	});
														  
																});	
					
					
					
			/*		Here is code for admin Video*/
					
					$('#videoViewIdAdmin').click(function()			
							{
														
															var categoryid=$("#categoryId").val();
															var topicid=$("#topicId").val();
															var lanId=$("#lanId").val();
														
															
															$.ajax({
																
																  	type: "GET",
														       		 url: "/viewVideoAdmin",
														       		 data: { "categorname" : categoryid,"topicid":topicid,"lanId":lanId },		
														       		 contentType: "application/json",
														       		 success: function(result)
														       		 {
														       					 
														       			
														       			 //$("#VideoView").prop('disabled',false);
														       			 //$('#VideoView').html(result);
														       			
														       		        var res =  result;
														       		     
														       		        source =  document.getElementById('storedVideoId');
														       		        source.setAttribute('src', "http://localhost:8081/"+res);
														       		        source.setAttribute('type','video/mp4')

														       		        source.play(); //test playback of new video
														       		        
														       		       // $('#videoDiv').show()
														       		
																		},
																		
																			error : function(err){
																		console.log("not working. ERROR: "+JSON.stringify(err));
																	}
											
																});
													  
															});
					
				
					
					$('#videoViewIdAdmin').click(function()			
							{
														
															var categoryid=$("#categoryId").val();
															var topicid=$("#topicId").val();
															var lanId=$("#lanId").val();
														
															
															$.ajax({
																
																  	type: "GET",
														       		 url: "/viewVideoAdmin",
														       		 data: { "categorname" : categoryid,"topicid":topicid,"lanId":lanId },		
														       		 contentType: "application/json",
														       		 success: function(result)
														       		 {
														       		
														       		        var res =  result;
														       		        
														       		        //alert("NEW video path : " + res); //should be a valid path eg: https://example.com/myvideo.mp4

														       		        source =  document.getElementById('storedVideoId');
														       		     source.setAttribute('src', "http://localhost:8081/"+res);
														       		        source.setAttribute('type','video/mp4')

														       		        source.play(); //test playback of new video
														       		        
														       		       // $('#videoDiv').show()
														       		   
														       		
																		},
																		
																			error : function(err){
																		console.log("not working. ERROR: "+JSON.stringify(err));
																	}
											
																});
													  
															});
					
					
					/*here is code for video accepet or need to improvement*/
					
		$('#videoAcceptOrNeedToImprovemenetByAdmin').click(function()			
		{
						
						var categoryid=$("#categoryId").val();
						var topicid=$("#topicId").val();
						var lanId=$("#lanId").val();
					
						
						var vals=$("#VideoAcceptAdmin").val();
						
						
						if(vals == '0')
						 { 
							 $('#msgVideoCommentByAdmin').css({'visibility':'hidden'}); 
							
							  alert("Select Accept Or Need To Improvement"); 
							  
		 		          }
						 else if(vals == '1'){
							
							 $('#msgVideoCommentByAdmin').css({'visibility':'hidden'}); 
							 
								$.ajax({
									
								  	type: "GET",
						       		 url: "/acceptAdminVideo",
						    		 data: { "categorname" : categoryid,"topicid":topicid,"lanId":lanId },		
						       		 contentType: "application/json",
						       		 success: function(result)
						       		{			 
									
						       			
						       			 $("#statusVideoByAdmin").prop('disabled',false);
						       			 $('#statusVideoByAdmin').html(result);
							       	
					       		
						       		},
											
										error : function(err){
										console.lo3g("not working. ERROR: "+JSON.stringify(err));
									}

								});	 
							  

						 }
						 else if(vals == '2')
						 {

					$('#msgVideoCommentByAdmin').css({'visibility':'visible'}); 
							 
							 
							var msg=$("#msgVideoCommentByAdmin").val();
								
								alert("mse admin player"+msg);
								
							$.ajax({
															
									
								  	type: "GET",
						       		 url: "/needToImprovemenetByAdmin",
						    		 data: { "categorname" : categoryid,"topicid":topicid,"lanId":lanId,"msg":msg },		
						       		 contentType: "application/json",
						       		 success: function(result)
						       		{
						       			 	
	
					       			 $("#statusVideoByAdmin").prop('disabled',false);
					       			 $('#statusVideoByAdmin').html(result);
						       	
						       		},
											
										error : function(err){
										console.lo3g("not working. ERROR: "+JSON.stringify(err));
									}

								});									 
							 

						 }
						

					});
					
					
					/*here is code for domain review  Video Acdept or Need To improvemenet*/
					
					$('#VideoAcceptDomain').click(function()			
							{
						
									var vals=$("#VideoAcceptDomain").val();
				
									 if(vals === '0')
									 { 
										  $('#videoNeedImprovement').css({'visibility':'hidden'}); 
					 		          }
									 else if(vals === '1')
									 {
										 	$('#videoNeedImprovement').css({'visibility':'hidden'}); 
				
									 }
									 else if(vals === '2')
									 {
										 
										 $('#videoNeedImprovement').css({'visibility':'visible'}); 											 
										 

									 }
									 
									 
							});
					
					
				/*	Here is code keywod accept or need to improvement*/
					
				
					
					$('#KeywordAcceptDomain').click(function()			
							{
						
									var vals=$("#KeywordAcceptDomain").val();
				
									 if(vals === '0')
									 { 
										  $('#keywordNeedImprovement').css({'visibility':'hidden'}); 
					 		          }
									 else if(vals === '1')
									 {
										 	$('#keywordNeedImprovement').css({'visibility':'hidden'}); 
				
									 }
									 else if(vals === '2')
									 {
										 
										 $('#keywordNeedImprovement').css({'visibility':'visible'}); 											 
										 

									 }
									 
									 
							});
					
					
				/*	end*/
					
					
	/*here is code for video accepet or need to improvement*/
					
		$('#videoAcceptOrNeedToImprovemenetByDomain').click(function()			
		{
					
					
						var categoryid=$("#categoryId").val();
						var topicid=$("#topicId").val();
						var lanId=$("#lanId").val();
					
						
						var vals=$("#VideoAcceptDomain").val();
						
					
						if(vals == '0')
						 { 
							  alert("Select Accept Or Need To Improvement"); 
							  
		 		          }
						 else if(vals == '1')
						 {
							 
						
								$.ajax({
									
								  	type: "GET",
						       		 url: "/acceptVideoByDomain",
						    		 data: { "categorname" : categoryid,"topicid":topicid,"lanId":lanId },		
						       		 contentType: "application/json",
						       		 success: function(result)
						       		{
						       			 
					       			 $("#statusVideoByDomain").prop('disabled',false);
					       			 $('#statusVideoByDomain').html(result);
						       	
						       		},
											
										error : function(err){
										console.lo3g("not working. ERROR: "+JSON.stringify(err));
									}

								});	 
							  

						 }
						 else if(vals == '2')
						 {
							 
					$.ajax({
									
								  	type: "GET",
						       		 url: "/needToImprovemenetByDomain",
						    		 data: { "categorname" : categoryid,"topicid":topicid,"lanId":lanId },		
						       		 contentType: "application/json",
						       		 success: function(result)
						       		{
						       			 
					       			 $("#statusVideoByDomain").prop('disabled',false);
					       			 $('#statusVideoByDomain').html(result);
						       	
						       		},
											
										error : function(err){
										console.lo3g("not working. ERROR: "+JSON.stringify(err));
									}

								});									 
							 

						 }
						

					});
					
		// Here is code for Domain review Accept or Need To Improvement
		
		
		$('#scriptAcceptOrNeedToImprovemenetDomain').click(function()			
	{
						
							var categoryid=$("#categoryId").val();
							var topicid=$("#topicId").val();
							var lanId=$("#lanId").val();
			
							var vals=$("#scriptAcceptDomain").val();
							
							

							if(vals == '0')
							{ 
								  alert("Select Accept Or Need To Improvement"); 
								  
							}
							 else if(vals == '1')
							 {		
								
										$.ajax({
																										
										  	type: "GET",
								       		 url: "/commentOnScript",
								       		 data: { "categorname" : categoryid,"topicid":topicid,"lanId":lanId},		
								       		 contentType: "application/json",
								       		 success: function(result)
								       		 {
								       			 
								       			 $("#saveCommentScript").prop('disabled',false);
								       			 $('#saveCommentScript').html(result);
								       		
								       			 
												},
												
													error : function(err){
												console.log("not working. ERROR: "+JSON.stringify(err));
											}
							
										});
					
							 }else if (vals == "2") 
							 {
							  
								 var msgScript=$("#msgScriptDomain").val();
							
						$.ajax({
								 		
										
									  	type: "GET",
							       		 url: "/needToImpScriptByDomain",
							       		 data: { "categorname" : categoryid,"topicid":topicid,"lanId":lanId,"msgScript":msgScript},		
							       		 contentType: "application/json",
							       		 success: function(result)
							       		 {
							       			
							       			 
							       			 $("#saveCommentScript").prop('disabled',false);
							       			 $('#saveCommentScript').html(result);
							       		
							       			 
											},
											
												error : function(err){
											console.log("not working. ERROR: "+
													
													
														JSON.stringify(err));
										}
						
									});
								 
								 
								 
								 
							}
		  
				});
				
		
		
		
		
	/*Here is code for comment on componenet script Quality accept or need To Improvement*/
		
		$('#scriptAcceptOrNeedToImprovemenet').click(function()			
		{
				
					var categoryid=$("#categoryId").val();
					var topicid=$("#topicId").val();
					var lanId=$("#lanId").val();
					
					

					var vals=$("#scriptAccept").val();
					
					

					if(vals == '0')
					{ 
						  alert("Select Accept Or Need To Improvement"); 
						  
					}
					 else if(vals == '1')
					 {		
								
					
						 
								$.ajax({
																								
								  	type: "GET",
						       		 url: "/commentOnScriptByQuality",
						       		 data: { "categorname" : categoryid,"topicid":topicid,"lanId":lanId},		
						       		 contentType: "application/json",
						       		 success: function(result)
						       		 {
						       			 
						       			
						       			 $("#saveCommentScript").prop('disabled',false);
						       			 $('#saveCommentScript').html(result);
						       		
						       			 
										},
										
											error : function(err){
										console.log("not working. ERROR: "+JSON.stringify(err));
									}
					
								});
			
			
					 }else if (vals == "2") 
					 {
					  
						 var msgScript=$("#msgScriptQuality").val();
					
				$.ajax({
						 		
								
							  	type: "GET",
					       		 url: "/needToImpScriptByQuality",
					       		 data: { "categorname" : categoryid,"topicid":topicid,"lanId":lanId,"msgScript":msgScript},		
					       		 contentType: "application/json",
					       		 success: function(result)
					       		 {
					       			
					       			 
					       			 $("#saveCommentScript").prop('disabled',false);
					       			 $('#saveCommentScript').html(result);
					       		
					       			 
									},
									
										error : function(err){
									console.log("not working. ERROR: "+
											
											
												JSON.stringify(err));
								}
				
							});
						 
						 
						 
						 
					}
  
		});
		
		// Here is  code for Quality outline selection 
		
	$('#OutlineAccepOrNeedToImprovementQuality').click(function()			
	{
		
		
			var vals=$("#outlineQualitAceept").val();
			
			
			if(vals ==='0')
			 { 
				  $('#msgQualitytOutline').css({'visibility':'hidden'}); 
				  
		      }
			
			 else if(vals === '1')
			 {
				 	$('#msgQualitytOutline').css({'visibility':'hidden'});
					 

			 }
			 else if(vals === '2')
			 {
				 
				 $('#msgQualitytOutline').css({'visibility':'visible'}); 											 
				 
			 }
	
		});
		
		// here is code for Quality Outline Code  for submition 
		
		
		$('#submitQualityOutlineStatus').click(function()			
		{
			
			
			var categoryid=$("#categoryId").val();
			var topicid=$("#topicId").val();
			var lanId=$("#lanId").val();
			
			var vals=$("#outlineQualitAceept").val();
			
			if(vals == '0')	
			 { 
				alert("Accept Or Need To Improvement");
	
		       }
			 else if(vals == '1')
			 {
				 
				 
				 	
		$.ajax({
			
		
						
					  	type: "GET",
			       		 url: "/acceptOutlineByQuality",
			       		 data: { "categorname" : categoryid,"topicid":topicid,"lanId":lanId},		
			       		 contentType: "application/json",
			       		 success: function(result)
			       		 {
			       			 
			       			 
			       			 
			       			 $("#commentOutlineByQuality").prop('disabled',false);
			       			 $('#commentOutlineByQuality').html(result);
			       		
			       			 
							},
							
								error : function(err){
							console.log("not working. ERROR: "+JSON.stringify(err));
						}
		
					}); 	

			 }
			 else if(vals == '2')
			 {
			
				 var msg=$("#msgQualitytOutline").val();
				 
		$.ajax({
						
				     type: "GET",
		       		 url: "/needToImprovementOutLineByQuality",
		       		 data: { "categorname" : categoryid,"topicid":topicid,"lanId":lanId,"msg":msg},		
		       		 contentType: "application/json",
		       		 success: function(result)
		       		 {
		       			 
		       			 $("#commentOutlineByQuality").prop('disabled',false);
		       			 $('#commentOutlineByQuality').html(result);
		       		
		       			 
						},
						
							error : function(err){
						console.log("not working. ERROR: "+JSON.stringify(err));
					}
	
				}); 
	
				 
				 
			 }
			
			
			
		});
		
	// Here is code for slide View into Quality		
		
		$('#slideModaleView').click(function()			
	{
							
			
			
												var categoryid=$("#categoryId").val();
												var topicid=$("#topicId").val();
												var lanId=$("#lanId").val();
												$.ajax({
													
													  	type: "GET",
											       		 url: "/slidePdfQuality",
											       		 data: { "categorname" : categoryid,"topicid":topicid,"lanId":lanId },		
											       		 contentType: "application/json",
											       		 success: function(result)
											       		 {
											       		 	var res =  result;
											       		 	
											       		        source =  document.getElementById('SlidePdfQuality');
											       		        source.setAttribute('href',res);
											       		       // source.setAttribute('type','video/mp4')

											       		        source.play(); 
											       			 
											      
															},
															
																error : function(err){
															console.log("not working. ERROR: "+JSON.stringify(err));
														}
								
													});
										  
												});
		
});

 // Slide Accept Or Need To Improvement


	$('#slideAcceptOrNeedImp').click(function()			
		{
		
			var vals=$("#slideAcceptByQuality").val();
			
		
			if(vals === '0')
			 { 
				  $('#slideNeedToImp').css({'visibility':'hidden'}); 
		          }
			 else if(vals === '1')
			 {
				 
				 	$('#slideNeedToImp').css({'visibility':'hidden'});

			 }
			 else if(vals === '2')
			 {
				 
				 $('#slideNeedToImp').css({'visibility':'visible'}); 											 
				 
			 }
	
		
		});
	
	//Here is code for save comment into  slide
	
			$('#slideAcceptOrNeedToImprovemenetByQuality').click(function()			
			{
		
						var categoryid=$("#categoryId").val();
						var topicid=$("#topicId").val();
						var lanId=$("#lanId").val();
						var vals=$("#slideAcceptByQuality").val();
		
				if(vals == '0')
				 { 
					
						alert("Select Accept Or Need To Improvement");
					
						// here is  code for Script 	// here is  code for Script css({'visibility':'hidden'}); 
					 
			     }
				 else if(vals == '1')
				 {
			
					 	 $.ajax({
								
							  	type: "GET",
					       		 url: "/acceptSlideByQuality",
					    		 data: { "categorname" : categoryid,"topicid":topicid,"lanId":lanId },		
					       		 contentType: "application/json",
					       		 success: function(result)
					       		{
					       			
					       		 alert("result is"+result);
					       			 
				       			 $("#statusSlideByQuality").prop('disabled',false);
				       			 $('#statusSlideByQuality').html(result);
				       		
					       		},
										
									error : function(err){
									console.lo3g("not working. ERROR: "+JSON.stringify(err));
								}

							});	  
	
				 }
				 else if(vals == '2')
				 {
					 
				 $('#slideNeedToImp').css({'visibility':'visible'}); 
					 
					 var msg=$("#slideCommentMsg").val();
					 
					 $.ajax({
							
						  	type: "GET",
				       		 url: "/needToImprovementSlideByQuality",
				    		 data: { "categorname" : categoryid,"topicid":topicid,"lanId":lanId,'msg':msg},		
				       		 contentType: "application/json",
				       		 success: function(result)
				       		{
				       			
				       	
					       			 $("#statusSlideByQuality").prop('disabled',false);
					       			 $('#statusSlideByQuality').html(result);
						     
				       		},
									
								error : function(err){
								console.lo3g("not working. ERROR: "+JSON.stringify(err));
							}

						});	  
					 
					 
				 }
				
				
			});
				
		// here is  code for Script for Quality Review					
		$('#scriptStatusAccept').click(function()			
			{
					
					var vals=$("#scriptAccept").val();
					if(vals === '0')
					{ 
						$('#msgScriptQuality').css({'visibility':'hidden'}); 
					}
					else if(vals === '1')
				   {
										 
						$('#msgScriptQuality').css({'visibility':'hidden'});
		
					}
					else if(vals === '2')
					{
											 
						$('#msgScriptQuality').css({'visibility':'visible'}); 											 
											 
					 }
				
		});
		
		// Here is code for Script for Domain review
		
		$('#scriptStatusAcceptDomain').click(function()			
				{
						
						var vals=$("#scriptAcceptDomain").val();
						
						if(vals === '0')
						{ 
							$('#msgScriptDomain').css({'visibility':'hidden'}); 
						}
						else if(vals === '1')
					   {
											 
							$('#msgScriptDomain').css({'visibility':'hidden'});
			
						}
						else if(vals === '2')
						{
												 
							$('#msgScriptDomain').css({'visibility':'visible'}); 											 
												 
						 }
						
					
			});
		
		// Here is code for Accept Or Need To Improvement
		
		
		
		
	
		// Here is code  for keyword   Quality Review	
		
		$('#keywordAccepOrNeedToImprovementQuality').click(function()			
		{
			
			
			
				var vals=$("#keywordQualitAceept").val();
		
			
				
						if(vals === '0')
						{ 
							
							$('#msgkeywordQuality').css({'visibility':'hidden'}); 
							
						}
						else if(vals === '1')
					   {
											 
							$('#msgkeywordQuality').css({'visibility':'hidden'});
			
						}
						else if(vals === '2')
						{
												 
							$('#msgkeywordQuality').css({'visibility':'visible'}); 											 
												 
						}
		
		});
		
		// here is code for Video review into Quality
		
		$('#VideoAccepOrNeedToImprovementQuality').click(function()			
				{
					
				
						var vals=$("#videoQualitAceept").val();
				
					
						
								if(vals === '0')
								{ 
									
									$('#msgVideoQuality').css({'visibility':'hidden'}); 
									
								}
								else if(vals === '1')
							   {
													 
									$('#msgVideoQuality').css({'visibility':'hidden'});
					
								}
								else if(vals === '2')
								{
														 
									$('#msgVideoQuality').css({'visibility':'visible'}); 											 
														 
								}
				
				});
		
		
		
		
		
		// Here is code for Domain review -Slide
		
		$('#SlideStatusAccept').click(function()			
				{
					
				
						var vals=$("#SlideAcceptDomain").val();
				
					
						
								if(vals === '0')
								{ 
									
									$('#slideNeedImprovement').css({'visibility':'hidden'}); 
									
								}
								else if(vals === '1')
							   {
													 
									$('#slideNeedImprovement').css({'visibility':'hidden'});
					
								}
								else if(vals === '2')
								{
														 
									$('#slideNeedImprovement').css({'visibility':'visible'}); 											 
														 
								}
				
				});
		
		
		
		$('#slideAcceptOrNeedToImprovemenetByDomain').click(function()			
		{
					
									var categoryid=$("#categoryId").val();
									var topicid=$("#topicId").val();
									var lanId=$("#lanId").val();
									
									
									var vals=$("#SlideAcceptDomain").val();
					
							if(vals == '0')
							 { 
								
									alert("Select Accept Or Need To Improvement");
								
									// here is  code for Script 	// here is  code for Script css({'visibility':'hidden'}); 
								 
						     }
							 else if(vals == '1')
							 {
						
								 
								 	 $.ajax({
											
										  	type: "GET",
								       		 url: "/acceptSlideByDomain",
								    		 data: { "categorname" : categoryid,"topicid":topicid,"lanId":lanId },		
								       		 contentType: "application/json",
								       		 success: function(result)
								       		{
								       		
								       			 
							       			 $("#statusSlideByDomain").prop('disabled',false);
							       			 $('#statusSlideByDomain').html(result);
							       		
								       		},
													
												error : function(err){
												console.lo3g("not working. ERROR: "+JSON.stringify(err));
											}

										});	  
				
							 }
							 else if(vals == '2')
							 {
			 
								 var msg=$("#slideCommentMsg").val();
								
								 $.ajax({
										
									  	type: "GET",
							       		 url: "/needToImpSlideByDomain",
							    		 data: { "categorname" : categoryid,"topicid":topicid,"lanId":lanId,'msg':msg},		
							       		 contentType: "application/json",
							       		 success: function(result)
							       		{
							       			 
							       			 $("#statusSlideByDomain").prop('disabled',false);
								       		 $('#statusKeywordByQuality').html(result);
								       			 
									     
							       		},
												
											error : function(err){
											console.lo3g("not working. ERROR: "+JSON.stringify(err));
										}

									});	  
								 
								 
							 }
							

				});

		
		
		
		
		
		//End Slide for DOmain review
		
		
		
		
		
		
		
		
		//here is code for  Accept Or Need To Improvement Script
		
		$('#KeyWordAcceptOrNeedToImprovemenetByQuality').click(function()			
		{
			
							var categoryid=$("#categoryId").val();
							var topicid=$("#topicId").val();
							var lanId=$("#lanId").val();
							
							
							var vals=$("#keywordQualitAceept").val();
			
					if(vals == '0')
					 { 
						
							alert("Select Accept Or Need To Improvement");
						
							// here is  code for Script 	// here is  code for Script css({'visibility':'hidden'}); 
						 
				     }
					 else if(vals == '1')
					 {
				
						 
						 	 $.ajax({
									
								  	type: "GET",
						       		 url: "/acceptKeywordByQuality",
						    		 data: { "categorname" : categoryid,"topicid":topicid,"lanId":lanId },		
						       		 contentType: "application/json",
						       		 success: function(result)
						       		{
						       		
						       			 
					       			 $("#statusKeywordByQuality").prop('disabled',false);
					       			 $('#statusKeywordByQuality').html(result);
					       		
						       		},
											
										error : function(err){
										console.lo3g("not working. ERROR: "+JSON.stringify(err));
									}

								});	  
		
					 }
					 else if(vals == '2')
					 {
	 
						 var msg=$("#keywordViewInDomainKeyword").val();
						
						 $.ajax({
								
							  	type: "GET",
					       		 url: "/needToImprovementKeywordByQuality",
					    		 data: { "categorname" : categoryid,"topicid":topicid,"lanId":lanId,'msg':msg},		
					       		 contentType: "application/json",
					       		 success: function(result)
					       		{
					       			 
					       			 $("#statusKeywordByQuality").prop('disabled',false);
						       		 $('#statusKeywordByQuality').html(result);
						       			 
							     
					       		},
										
									error : function(err){
									console.lo3g("not working. ERROR: "+JSON.stringify(err));
								}

							});	  
						 
						 
					 }
					

		});
		
		$('#VideoAcceptOrNeedToImprovemenetByQuality').click(function()			
				{
			//chage
	
					
									var categoryid=$("#categoryId").val();
									var topicid=$("#topicId").val();
									var lanId=$("#lanId").val();
									
									
									var vals=$("#videoQualitAceept").val();
					
							if(vals == '0')
							 { 
								
									alert("Select Accept Or Need To Improvement");
								
									// here is  code for Script 	// here is  code for Script css({'visibility':'hidden'}); 
								 
						     }
							 else if(vals == '1')
							 {
						
								 
								 	 $.ajax({
											
										  	type: "GET",
								       		 url: "/acceptVideoByQuality",
								    		 data: { "categorname" : categoryid,"topicid":topicid,"lanId":lanId },		
								       		 contentType: "application/json",
								       		 success: function(result)
								       		{
								       			 
							       			 $("#statusQualityByQuality").prop('disabled',false);
							       			 $('#statusQualityByQuality').html(result);
							       		
								       		},
													
												error : function(err){
												console.lo3g("not working. ERROR: "+JSON.stringify(err));
											}

										});	  
				
							 }
							 else if(vals == '2')
							 {
			 
								 var msg=$("#msgkeywordQuality").val();
								
								 $.ajax({
										
									  	type: "GET",
							       		 url: "/needToImprovementQualityByQuality",
							    		 data: { "categorname" : categoryid,"topicid":topicid,"lanId":lanId,'msg':msg},		
							       		 contentType: "application/json",
							       		 success: function(result)
							       		{
							       			 
							       			 $("#statusQualityByQuality").prop('disabled',false);
								       		 $('#statusQualityByQuality').html(result);
								       			 
									     
							       		},
												
											error : function(err){
											console.lo3g("not working. ERROR: "+JSON.stringify(err));
										}

									});	  
								 
								 
							 }
							

				});
				
				
		
		
		
		

