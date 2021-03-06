
$(document)
		.ready(
				function() {
					 $('.pending-upload').tooltip({ title: 'Pending' });
					 $('.admin-review').tooltip({ title: 'Waiting for Admin Review' });
					 $('.domain-review').tooltip({ title: 'Waiting for Domain Review' });
					 $('.quality-review').tooltip({ title: 'Waiting for Quality Review' });
					 $('.review-accepted').tooltip({ title: 'Accepted' });
					 $('.review-improvement').tooltip({ title: 'Need Improvement' });
					 $('.not-required').tooltip({ title: 'Not Required' });

					/*--------------- constants ---------------*/
					const SUCCESS = 1;
					const ERROR = 0;

					/*--------------- constants ---------------*/
					// retrieve latest tab shown before refresh
					var activeTab = localStorage.getItem('activeTab');
					if (activeTab) {
						$('#nav-tab a[href="#' + activeTab + '"]').tab('show');
						localStorage.setItem('activeTab', "");
						$('.approve-success-msg').text(
								localStorage.getItem('msg'));
						localStorage.setItem('msg', "");
					}

					/* master trainer */

					var activeTab = localStorage.getItem('activeTab');
					if (activeTab) {
						$('#v-pills-tab a[href="#' + activeTab + '"]').tab(
								'show');
						localStorage.setItem('activeTab', "");
						$('.tab-pane').text(localStorage.getItem('msg'));
						localStorage.setItem('msg', "");
					}

					function showStatus(status, msg) {
						// status : 1 - success , 0 - failure
						$('.alert-msg').show();
						$('.alert-msg').html(msg);
						if (status) {
							$('.alert-msg').addClass('alert-success');
						} else {
							$('.alert-msg').addClass('alert-danger');
						}

					}
					$('.modal-status').on('hidden.bs.modal', function() {
						$('.alert-msg').hide();

					});

					$('#OutlineAcceptOrNeedTiImprovemenet').on(
							'hidden.bs.modal', function() {
								location.reload();

							});

					$('#approveContributorId').on('show.bs.tab', function() {
						location.reload();

					});

					$('#KeywordStatusAccept').on('hidden.bs.modal', function() {
						location.reload();

					});

					$('#videoViewIdAdmin').on('hidden.bs.modal', function() {
						location.reload();

					});

					$('#videoViewIdDomain').on('hidden.bs.modal', function() {
						location.reload();

					});

					$('#VideoStatusAccept').on('hidden.bs.modal', function() {
						location.reload();

					});

					$('#scriptStatusAcceptDomain').on('hidden.bs.modal',
							function() {
								location.reload();

							});

					$('#VideoStatusAccept').on('hidden.bs.modal', function() {
						location.reload();

					});

					$('.nav-item').on(
							'click',
							function() {
								localStorage.setItem('msg', "");
								$('.approve-success-msg').text(
										localStorage.getItem('msg'));
							});

					// Contributor

					// here is code for keyword review
					$('#keywordModale').on('hidden.bs.modal', function() {
						location.reload();

					});

					// here is code for Script
					$('#scriptModale').on('hidden.bs.modal', function() {
						location.reload();

					});

					// Here is code for
					$('#slideModale').on('hidden.bs.modal', function() {
						location.reload();

					});

					$('#videoModel').on('hidden.bs.modal', function() {
						location.reload();

					});

					// Admin

					$('#VideoStatusAccept').on('hidden.bs.modal', function() {
						location.reload();

					});

					// Quality

					$('#OutlineAccepOrNeedToImprovementQuality').on(
							'hidden.bs.modal', function() {
								location.reload();

							});

					$('#scriptStatusAccept').on('hidden.bs.modal', function() {
						location.reload();

					});

					$('#slideAcceptOrNeedImp').on('hidden.bs.modal',
							function() {
								location.reload();

							});

					$('#VideoAccepOrNeedToImprovementQuality').on(
							'hidden.bs.modal', function() {
								location.reload();

							});

					$('#keywordAccepOrNeedToImprovementQuality').on(
							'hidden.bs.modal', function() {
								location.reload();

							});

					$('#categoryNameList').change(function() {

					});

					// Here is code for category display into category and
					// language

					$('#categoryId')
							.change(
									function() {
										var categoryid = $("#categoryNameList")
												.val();
										var languageid = $("#inputLanguageList")
												.val();

										$
												.ajax({

													type : "GET",
													url : "/loadCategoryAndLanguage",
													data : {
														"id" : categoryid,
														"lanid" : language
													},
													contentType : "application/json",
													success : function(result) {

														var html = '';
														var len = result.length;
														html += '<option value="0">Select language</option>';
														for (var i = 0; i < len; i++) {

															html += '<option value="'+ result[i]+ '">'+ result[i]+ '</option>';
														}
														html += '</option>';

														$("#inputLanguageList").prop('disabled',false);
														$('#inputLanguageList').html(html);
													},

													error : function(err) {
														console.log("not working. ERROR: "+ JSON.stringify(err));
													}
												});
									});

					
				// Here is code for display category according to language
					
					$('#languageContributerId')
					.change(
							
							function() {
								
								var languageid = $("#languageContributerId").val();
	
								$.ajax({

											type : "GET",
											url : "/loadcategoryBylanguage",
										
											data : {
												
												"languageid" : languageid,
												
											},
											contentType : "application/json",
											success : function(result) {

												var html = '';
												var len = result.length;
												html += '<option value="0">Select Category</option>';
												for (var i = 0; i < len; i++) {

													html += '<option value="'+ result[i]+ '">'+ result[i]+ '</option>';
												}
												html += '</option>';

												$("#categoryDomainId").prop('disabled',false);
												$('#categoryDomainId').html(html);
											},

											error : function(err) {
												console.log("not working. ERROR: "+ JSON.stringify(err));
											}
										});
							});
					
					
					
					
//					$('#categoryname').change(function() {
//										alert('clicked');
//										var categoryId = $(this).val();
//										console.log(categoryId);
//										$
//												.ajax({
//													type : "GET",
//													url : "/listTopicsByCategory",
//													data : {
//														"category" : categoryId
//													},
//													contentType : "application/json",
//													success : function(result) {
//														console.log(result);
//														var html = '';
//														var len = result.length;
//														html += '<option value="0">Select language</option>';
//														for (var i = 0; i < len; i++) {
//
//															html += '<option value="'
//																	+ result[i]
//																	+ '">'
//																	+ result[i]
//																	+ '</option>';
//														}
//														html += '</option>';
//
//														$("#inputTopic").prop('disabled',false);
//														$('#inputTopic').html(html);
//
//													},
//													error : function(err) {
//														console.log("not working. ERROR: "+ JSON.stringify(err));
//													}
//
//												});
//
//									});
					

					/* here we write code for calling Topic */

					$('#categoryId')
							.change(
									function() {

										var catgoryid = $(this).find(
												":selected").val();
										$
												.ajax({
													type : "GET",
													url : "/loadByCategoryTuturialTopic",
													data : {
														"id" : catgoryid
													},
													contentType : "application/json",
													success : function(result) {

														var html = '';
														var len = result.length;
														html += '<option value="0">Select Topic</option>';
														for (var i = 0; i < len; i++) {
															html += '<option value="'
																	+ result[i]
																	+ '">'
																	+ result[i]
																	+ '</option>';
														}
														html += '</option>';

														$("#inputTopic").prop(
																'disabled',
																false);
														$('#inputTopic').html(
																html);

													},

													error : function(err) {
														console
																.log("not working. ERROR: "
																		+ JSON
																				.stringify(err));
													}

												});

									});

					/* here we write code for calling language */

					$('#categoryId')
							.change(
									function() {

										var catgoryid = $(this).find(
												":selected").val();
										$
												.ajax({

													type : "GET",
													url : "/loadByCategoryTuturial",
													data : {
														"id" : catgoryid
													},
													contentType : "application/json",
													success : function(result) {

														var html = '';
														var len = result.length;
														html += '<option value="0">Select language</option>';
														for (var i = 0; i < len; i++) {
															html += '<option value="'
																	+ result[i]
																	+ '">'
																	+ result[i]
																	+ '</option>';
														}
														html += '</option>';

														$("#inputLanguage")
																.prop(
																		'disabled',
																		false);
														$('#inputLanguage')
																.html(html);

													},

													error : function(err) {
														console
																.log("not working. ERROR: "
																		+ JSON
																				.stringify(err));
													}

												});

									});

					// });
					//		
					//			  
					// });

					/* Here is code for select District */

					$('#stateNameId')
							.change(
									function() {

										var state = $(this).find(":selected")
												.val();

										$
												.ajax({
													type : "GET",
													url : "/loadDistrictByState",
													data : {
														"id" : state
													},
													contentType : "application/json",
													success : function(result) {

														var html = '';
														var len = result.length;
														html += '<option value="0">Select District</option>';
														for (var i = 0; i < len; i++) {
															html += '<option value="'
																	+ result[i]
																	+ '">'
																	+ result[i]
																	+ '</option>';
														}
														html += '</option>';

														$("#districtId").prop(
																'disabled',
																false);
														$('#districtId').html(
																html);

													},

													error : function(err) {
														console
																.log("not working. ERROR: "
																		+ JSON
																				.stringify(err));
													}

												});

									});

					/*
					 * Here is code for selection of title name according to
					 * category name
					 */

					$('#catMasId')
							.change(
									function() {

										var state = $(this).find(":selected")
												.val();

										$
												.ajax({
													type : "GET",
													url : "/loadBycategoryInFeedb",
													data : {
														"id" : state
													},
													contentType : "application/json",
													success : function(result) {

														var html = '';
														var len = result.length;
														html += '<option value="0">Select Training</option>';
														for (var i = 0; i < len; i++) {
															html += '<option value="'
																	+ result[i]
																	+ '">'
																	+ result[i]
																	+ '</option>';
														}
														html += '</option>';

														$("#feedbackmasterId").prop(
																		'disabled',
																		false);
														$('#feedbackmasterId')
																.html(html);

													},

													error : function(err) {
														console
																.log("not working. ERROR: "
																		+ JSON
																				.stringify(err));
													}

												});

									});

					// here is code for pre requisite category
					
				$('#preRequsiteId').change(
							function() {
								var catgoryid = $(this).find(
										":selected").val();
							
								
								
								$.ajax({
											type : "GET",
											url : "/loadByCategoryTuturial",
											data : {
												
												"id" : catgoryid
											},
											contentType : "application/json",
											success : function(result) 
											{
												
											
												var html = '';
												var len = result.length;
												html += '<option value="0">Select Topic</option>';
												for (var i = 0; i < len; i++) {
													html += '<option value="'
															+ result[i]
															+ '">'
															+ result[i]
															+ '</option>';
												}
												html += '</option>';

												
												
												$("#inputLanguageAll")
														.prop(
																'disabled',
																false);
												$('#inputLanguageAll')
														.html(html);

											},

											error : function(err) {
												console
														.log("not working. ERROR: "
																+ JSON
																		.stringify(err));
											}

										});

							});
				
				
				
				$('#preAcceptDomain').change(function() {
					
					var vals = $("#preAcceptDomain").val();

					if (vals === '2') {
						
						$('#preNeedImprovement').show();
						
					}else{
						
						$('#preNeedImprovement').hide();
					
					}
				
				});
				
				
				$('#preAcceptQuality').change(function() {
					
					var vals = $("#preAcceptQuality").val();

					if (vals === '2') 
					{
						$('#preNeedImprovementQuality').show();
						
					}else{
						
						$('#preNeedImprovementQuality').hide();
					
					}
				
				});
				
				
				
				/*   Here is code for comment on prerequsite on Domain Reviwer side   */
				
				
				$('#preAcceptOrNeedToImprovemenetByDomain').click(
						function() {

							var categoryid = $("#categoryId").val();
							var topicid = $("#topicId").val();
							var lanId = $("#lanId").val();
							var preCommentMsg = $("#preCommentMsg").val();
							

							alert(preCommentMsg);
							
							var vals = $("#preAcceptDomain").val();

							if (vals == '0') 
							{
								alert("Select Accept Or Need To Improvement");

							} else if (vals == '1') {

								$.ajax({
									
											type : "GET",
											url : "/acceptPrerequistic",
											data : {
												"categorname" : categoryid,
												"topicid" : topicid,
												"lanId" : lanId
											},
											contentType : "application/json",
											success : function(
													result) {
												showStatus(SUCCESS, result);
//												$("#statusVideoByDomain").prop('disabled',false);
//												$('#statusVideoByDomain').html(result);

											},

											error : function(err) {
												console.log("not working. ERROR: "+ JSON.stringify(err));
												result = "Error";
												showStatus(ERROR, result);
											}
										});

							} else if (vals == '2') {

							
								$
										.ajax({

											type : "GET",
											url : "/needToImpKeywordByDomainPre",
											data : {
												"categorname" : categoryid,
												"topicid" : topicid,
												"lanId" : lanId,
												"preCommentMsg":preCommentMsg
											},
											contentType : "application/json",
											success : function(
													result) {
//												$("#statusVideoByDomain").prop('disabled',false);
//												$('#statusVideoByDomain').html(result);
												showStatus(SUCCESS, result);

											},

											error : function(err) {
												console.log("not working. ERROR: "+ JSON.stringify(err));
												result = "Error";
												showStatus(ERROR, result);
											}

										});

							}

						});
				

				
				
				

				/*		Here is code for Quality Reviwer prerequisite */
						
						$('#preAcceptOrNeedToImprovemenetByQuality').click(
								function() {

									var categoryid = $("#categoryId").val();
									var topicid = $("#topicId").val();
									var lanId = $("#lanId").val();
									var preCommentMsg = $("#preCommentMsgTest").val();
									

									var vals = $("#preAcceptQuality").val();

									if (vals == '0') 
									{
										alert("Select Accept Or Need To Improvement");

									} else if (vals == '1') {

										$.ajax({
											
													type : "GET",
													url : "/acceptPrerequisticQuality",
													data : {
														"categorname" : categoryid,
														"topicid" : topicid,
														"lanId" : lanId,
														"preCommentMsg":preCommentMsg
														
													},
													contentType : "application/json",
													success : function(
															result) {
														showStatus(SUCCESS, result);
														

													},

													error : function(err) {
														console.log("not working. ERROR: "+ JSON.stringify(err));
														result = "Error";
														showStatus(ERROR, result);
													}
												});

									} else if (vals == '2') {

									
										$
												.ajax({

													type : "GET",
													url : "/needToImpKeywordByQualityPre",
													data : 
													{
														"categorname" : categoryid,
														"topicid" : topicid,
														"lanId" : lanId,
														"preCommentMsg":preCommentMsg
													},
													contentType : "application/json",
													success : function(
															result) {
//														$("#statusVideoByDomain").prop('disabled',false);
//														$('#statusVideoByDomain').html(result);
														showStatus(SUCCESS, result);

													},

													error : function(err) {
														console.log("not working. ERROR: "+ JSON.stringify(err));
														result = "Error";
														showStatus(ERROR, result);
													}

												});

									}

								});


				
				// here is code for prerequisite  submit

				$('#uploadpreRequsiteId').click(function() 
				{
							alert('here uploadpreRequsiteId');
							var p_catgoryid = $("#preRequsiteId").val();
							
							var p_topic = $("#inputLanguageAll").val();
							
							var p_lanId = $("#lanId").val();
							
							
							var categoryid = $("#categoryId").val();
							var topicid = $("#topicId").val();
							var lanId = $("#lanId").val();
							
							$.ajax({
										type : "GET",
										url : "/loadCatAndTopicInPre",
										data : {
											
											"p_id" : p_catgoryid,
											"p_topic": p_topic,
											"p_lanId": p_lanId,
											"categorname" : categoryid,
											"topicid" : topicid,
											"lanId" : lanId
										},
										contentType : "application/json",
										success : function(result) 
										{

											alert("Successfully Save");
											$("#exampleModalLabelKeyword")
													.prop(
															'disabled',
															false);
											$("#exampleModalLabelKeyword")
													.html(html);

										},

										error : function(err) {
											console
													.log("not working. ERROR: "
															+ JSON
																	.stringify(err));
										}

									});

						});

				
				
				
				
				
				

					
					/*
					 * Here is code for selection of title name according to
					 * category name View csv file recored
					 */

					$('#catSelectedId')
							.change(
									function() {

										var state = $(this).find(":selected")
												.val();

										$
												.ajax({
													type : "GET",
													url : "/loadBycategoryInFeedb",
													data : {
														"id" : state
													},
													contentType : "application/json",
													success : function(result) {

														var html = '';
														var len = result.length;
														html += '<option value="0">Select Title</option>';
														for (var i = 0; i < len; i++) {
															html += '<option value="'
																	+ result[i]
																	+ '">'
																	+ result[i]
																	+ '</option>';
														}
														html += '</option>';

														$("#titleNameId").prop(
																'disabled',
																false);
														$('#titleNameId').html(
																html);

													},

													error : function(err) {
														console
																.log("not working. ERROR: "
																		+ JSON
																				.stringify(err));
													}

												});

									});

					/* Here is code for distrcit Selection for adding city */
					$('#stateDistrictId')
							.change(
									function() {

										var state = $(this).find(":selected")
												.val();

										$
												.ajax({
													type : "GET",
													url : "/loadDistrictByState",
													data : {
														"id" : state
													},
													contentType : "application/json",
													success : function(result) {

														var html = '';
														var len = result.length;
														html += '<option value="0">Select District</option>';
														for (var i = 0; i < len; i++) {
															html += '<option value="'
																	+ result[i]
																	+ '">'
																	+ result[i]
																	+ '</option>';
														}
														html += '</option>';

														$("#districtCityId")
																.prop(
																		'disabled',
																		false);
														$('#districtCityId')
																.html(html);

													},

													error : function(err) {
														console
																.log("not working. ERROR: "
																		+ JSON
																				.stringify(err));
													}

												});

									});

					$('#districtId')
							.change(
									function() {

										var dist = $(this).find(":selected")
												.val();

										$
												.ajax({
													type : "GET",
													url : "/loadCityByDistrict",
													data : {
														"id" : dist
													},
													contentType : "application/json",
													success : function(result) {

														var html = '';
														var len = result.length;
														html += '<option value="0">Select City</option>';
														for (var i = 0; i < len; i++) {
															html += '<option value="'
																	+ result[i]
																	+ '">'
																	+ result[i]
																	+ '</option>';
														}
														html += '</option>';

														$("#cityId").prop(
																'disabled',
																false);
														$('#cityId').html(html);

													},

													error : function(err) {
														console
																.log("not working. ERROR: "
																		+ JSON
																				.stringify(err));
													}

												});

									});

					/*
					 * Here is code for access topic according to category
					 * master trainer
					 */

					// $("#catMasterId").change(function(){
					// 2a7c4fbe32196d9c8817df70b2f7bd828dca62f6
					$('#stateNameId')
							.change(
									function() {

										var state = $(this).find(":selected")
												.val();

										$.ajax({
													type : "GET",
													url : "/loadDistrictByState",
													data : {
														"id" : state
													},
													contentType : "application/json",
													success : function(result) {

														var html = '';
														var len = result.length;
														html += '<option value="0">Select District</option>';
														for (var i = 0; i < len; i++) {
															html += '<option value="'
																	+ result[i]
																	+ '">'
																	+ result[i]
																	+ '</option>';
														}
														html += '</option>';

														$("#districtId").prop(
																'disabled',
																false);
														$('#districtId').html(
																html);

													},

													error : function(err) {
														console
																.log("not working. ERROR: "
																		+ JSON
																				.stringify(err));
													}

												});

									});

					/* Here is code for distrcit Selection for adding city */
					$('#stateDistrictId')
							.change(
									function() {

										var state = $(this).find(":selected")
												.val();

										$
												.ajax({
													type : "GET",
													url : "/loadDistrictByState",
													data : {
														"id" : state
													},
													contentType : "application/json",
													success : function(result) {

														var html = '';
														var len = result.length;
														html += '<option value="0">Select District</option>';
														for (var i = 0; i < len; i++) {
															html += '<option value="'
																	+ result[i]
																	+ '">'
																	+ result[i]
																	+ '</option>';
														}
														html += '</option>';

														$("#districtCityId")
																.prop(
																		'disabled',
																		false);
														$('#districtCityId')
																.html(html);

													},

													error : function(err) {
														console
																.log("not working. ERROR: "
																		+ JSON
																				.stringify(err));
													}

												});

									});

					$('#districtId')
							.change(
									function() {

										var dist = $(this).find(":selected")
												.val();

										$
												.ajax({
													type : "GET",
													url : "/loadCityByDistrict",
													data : {
														"id" : dist
													},
													contentType : "application/json",
													success : function(result) {

														var html = '';
														var len = result.length;
														html += '<option value="0">Select City</option>';
														for (var i = 0; i < len; i++) {
															html += '<option value="'
																	+ result[i]
																	+ '">'
																	+ result[i]
																	+ '</option>';
														}
														html += '</option>';

														$("#cityId").prop(
																'disabled',
																false);
														$('#cityId').html(html);

													},

													error : function(err) {
														console
																.log("not working. ERROR: "
																		+ JSON
																				.stringify(err));
													}

												});

									});

					/*
					 * Here is code for access topic according to category
					 * master trainer
					 */

					$("#catMasterId")
							.change(
									function() {

										var catgoryid = $(this).find(
												":selected").val();

										$
												.ajax({
													type : "GET",
													url : "/getTopicAccordingToCategory",
													data : {
														"id" : catgoryid
													},
													contentType : "application/json",
													success : function(result) {

														var html = '';
														var len = result.length;
														html += '<option value="0">Select Topic</option>';
														for (var i = 0; i < len; i++) {
															html += '<option value="'
																	+ result[i]
																	+ '">'
																	+ result[i]
																	+ '</option>';
														}
														html += '</option>';

														$("#lanMasterTrId")
																.prop(
																		'disabled',
																		false);
														$('#lanMasterTrId')
																.html(html);

													},

													error : function(err) {
														console
																.log("not working. ERROR: "
																		+ JSON
																				.stringify(err));

													}

												});

									});

					$('#OutlineAcceptOrNeedTiImprovemenet').on(
							'hidden.bs.modal', function() {
								location.reload();
							});

					$('#approveContributorId').on('show.bs.tab', function() {
						location.reload();
					});

					$('#scriptModale').on(
							'shown.bs.modal',
							function() {
								var categoryid = $("#categoryId").val();
								var topicid = $("#topicId").val();
								var lanId = $("#lanId").val();
								$.ajax({

									type : "GET",
									url : "/scriptPdf",
									data : {
										"categorname" : categoryid,
										"topicid" : topicid,
										"lanId" : lanId
									},
									contentType : "application/json",
									success : function(result) {
										var res = result;
										source = document
												.getElementById('viewScript');
										source.setAttribute('href', res);

										str = result[0].split("/");
										console.log(str);
										fileName = str[str.length - 1];
										console.log(str);
										$('#viewScript').html(fileName);
									},

									error : function(err) {
										console.log("not working. ERROR: "
												+ JSON.stringify(err));
									}
								});

							});

					$('#KeywordStatusAccept').on('hidden.bs.modal', function() {
						location.reload();
					});

					$('#videoViewIdAdmin').on('hidden.bs.modal', function() {
						location.reload();
					});

					$('#videoViewIdDomain').on('hidden.bs.modal', function() {
						location.reload();
					});

					$('#VideoStatusAccept').on('hidden.bs.modal', function() {
						location.reload();
					});

					$('#scriptStatusAcceptDomain').on('hidden.bs.modal',
							function() {
								location.reload();
							});

					$('#VideoStatusAccept').on('hidden.bs.modal', function() {
						location.reload();
					});

					$('.nav-item').on(
							'click',
							function() {
								localStorage.setItem('msg', "");
								$('.approve-success-msg').text(
										localStorage.getItem('msg'));
							});

					// Contributor

					// here is code for keyword review
					$('#keywordModale').on('hidden.bs.modal', function() {
						location.reload();

					});

					$('#keywordModale').on(
							'shown.bs.modal',
							function() {
								var categoryid = $("#categoryId").val();
								var topicid = $("#topicId").val();
								var lanId = $("#lanId").val();

								$.ajax({
									type : "GET",
									url : "/viewKeyword",
									data : {
										"categorname" : categoryid,
										"topicid" : topicid,
										"lanId" : lanId
									},
									contentType : "application/json",
									success : function(result) {
										$("#keyword").val(result);
										$('#keyword').prop('readonly', true);
										$("#keywordId").hide();

									},
									error : function(err) {
										console.log("not working. ERROR: "
												+ JSON.stringify(err));
									}

								});

							});

					// here is code for
					$('#outlineModalContri').on('hidden.bs.modal', function() {
						location.reload();

					});
					$('#outlineModalContri').on(
							'shown.bs.modal',
							function() {
							
								var categoryid = $("#categoryId").val();
								var topicid = $("#topicId").val();
								var lanId = $("#lanId").val();
								$.ajax({

									type : "GET",
									url : "/outlineView",
									data : {
										"categorname" : categoryid,
										"topicid" : topicid,
										"lanId" : lanId
									},
									contentType : "application/json",
									success : function(result) {
										if(result[0]==null){
											$('#editOutline').hide();
										}
										editor.setData(result[0]); // add
																	// retrieved
																	// outline
																	// content
																	// to editor
										editor.isReadOnly = true;
										
									},
									error : function(err) {
										console.log("not working. ERROR: "
												+ JSON.stringify(err));
									}

								});

							});

					// here is code for Script
					$('#scriptModale').on('hidden.bs.modal', function() {
						location.reload();

					});

					$('#slideModale').on('hidden.bs.modal', function() {
						location.reload();
					});

					/* load By Contributor user only contributor assign from */

//					$('#contributorId')
//							.click(
//									function() {
//										var userContributor = $(this).find(':selected').val();
//										$.ajax({
//											type : "GET",
//											url : "/loadLanguageByUser",
//											data : {
//												"id" : userContributor
//											},
//											contentType : "application/json",
//											success : function(result) {
//												var html = '';
//												var len = result.length;
//												html += '<option value="0">Select Language</option>';
//												for (var i = 0; i < len; i++) {
//													html += '<option value="'+ result[i]+ '">'+ result[i]+ '</option>';
//												}
//												html += '</option>';
//												$("#lanId").prop('disabled',false);
//												$('#lanId').html(html);
//											},
//											error : function(err) {
//												console.log("not working. ERROR: "+ JSON.stringify(err));
//													}
//												});
//									});
					/* here is code for download question */

					$('#inputLanguage1')
							.change(
									function() {

										var catgoryid = $(this).find(
												":selected").val();

										$
												.ajax({
													type : "GET",
													url : "/downloadQuestion",
													data : {
														"id" : catgoryid
													},
													contentType : "application/json",
													success : function(result) {

														var html = '';
														var len = result.length;
														html += '<a href="#">Click To Open</a>';
														for (var i = 0; i < len; i++) {

															html += '<a her="'
																	+ result[i]
																	+ '">'
																	+ '<a href='
																	+ result[i]
																	+ '>'
																	+ result[i]
																	+ '</a>'
																	+ '</option>';

														}
														html += '</option>';

														$("#input").prop(
																'disabled',
																false);

														$('#inputdiv').html(
																html);

													},

													error : function(err) {
														console
																.log("not working. ERROR: "
																		+ JSON
																				.stringify(err));

													}

												});

									});

					/*
					 * master trainer depending on language wet topic
					 */

					$('#inputLanguage')
							.change(
									function() {

										var catgoryid = $(this).find(
												":selected").val();

										$
												.ajax({
													type : "GET",
													url : "/loadByLangugaeTopic",
													data : {
														"id" : catgoryid
													},
													contentType : "application/json",
													success : function(result) {

														var html = '';
														var len = result.length;
														html += '<option value="0">Select Topic</option>';
														for (var i = 0; i < len; i++) {

															html += '<option value="'
																	+ result[i]
																	+ '">'
																	+ result[i]
																	+ '</option>';
														}
														html += '</option>';

														$("#selectLanguageId")
																.prop(
																		'disabled',
																		false);
														$('#selectLanguageId')
																.html(html);

													},

													error : function(err) {
														console
																.log("not working. ERROR: "
																		+ JSON
																				.stringify(err));
													}

												});

									});

					$('#slideModale').on(
							'shown.bs.modal',
							function() {

								var categoryid = $("#categoryId").val();

								var topicid = $("#topicId").val();

								var lanId = $("#lanId").val();

								$.ajax({

									type : "GET",

									url : "/sliedPdf",

									data : {
										"categorname" : categoryid,
										"topicid" : topicid,
										"lanId" : lanId
									},

									contentType : "application/json",

									success : function(result)

									{

										var res = result;

										source = document
												.getElementById('sliedPdf');

										source.setAttribute('href', res);
										str = result[0].split("/");
										console.log(str);
										fileName = str[str.length - 1];
										console.log(str);
										$('#sliedPdf').html(fileName);
									},

									error : function(err) {

										console.log("not working. ERROR: "
												+ JSON.stringify(err));

									}

								});

							});

					$('#lanId').change(
									function() {
										var languageName = $("#option :selected").text();
										$.ajax({
											type : "GET",
											url : "/loadCategoryByLanguage",
											data : {
												"id" : languageName
											},
											contentType : "application/json",
											success : function(result) {
												var html = '';
												var len = result.length;
												html += '<option value="0">Select Category</option>';
												for (var i = 0; i < len; i++) {
													html += '<option value="'+ result[i]+ '">'+ result[i]+ '</option>';
												}
												html += '</option>';
												$("#catgoryByContributor").prop('disabled',false);
												$('#catgoryByContributor').html(html);
											},
											error : function(err) {
												console.log("not working. ERROR: "+ JSON.stringify(err));
											}
										});
									});

					
//					question start
//					$('#fetch_questions').click(
//							function() {
//								alert('ques');
//								var categoryid = $('#catMasterId').val();
//								var topicid = $('#lanMasterTrId').val();
//								var lanId = $('#dwnByLanguageId').val();
//								$.ajax({
//									type : "GET",
//									url : "/displayQuestion",
//									data : {
//										"categorname" : categoryid,
//										"topicid" : topicid,
//										"lanId" : lanId
//									},
//									contentType : "application/json",
//									success : function(result) {
//										$('#questions').html(result);
//										console.log(result);
//										alert('success');
//									},
//									error : function(err) {
//										console.log("not working. ERROR: "+ JSON.stringify(err));
//										alert('error');
//									}
//								});
//							});
//					question end
					
					
					
					
					$('#catgoryByContributor').click(
							function() {
								// var languageName = $form.find( '#lanId'
								// ).val(),
								var category = $(this).find("option:selected").val();
								var languageName = $('#lanId').val();
								var userName = $('#contributorId').val();
								// var languageName=$("option :lanId").text();

								$.ajax({
									type : "GET",
									url : "/loadTopicByCategory",
									data : {
										"id" : category,
										"lanId" : languageName,
										"userName" : userName
									},
									contentType : "application/json",
									success : function(result) {
										var html = '';
										var len = result.length;
										for (var i = 0; i < len; i++) {
											html += '<option value="'+ result[i] + '">'+ result[i] + '</option>';
										}
										html += '</option>';
										$("#inputTopic").prop('disabled', false);
										$('#inputTopic').html(html);
									},
									error : function(err) {
										console.log("not working. ERROR: "
												+ JSON.stringify(err));
									}
								});

							});

					// here write code for keyword view //add content form
					$('#keywordModaleView').click(
							function() {

								var categoryid = $("#categoryId").val();
								var topicid = $("#topicId").val();
								var lanId = $("#lanId").val();

								$.ajax({
									type : "GET",
									url : "/viewKeyword",
									data : {
										"categorname" : categoryid,
										"topicid" : topicid,
										"lanId" : lanId
									},
									contentType : "application/json",
									success : function(result) {

										$("#keywordView").prop('disabled',
												false);
										$('#keywordView').html(result);

									},

									error : function(err) {
										console.log("not working. ERROR: "
												+ JSON.stringify(err));
									}

								});

							});

					// Here is Code for Quality Review keyword View

					$('#keywordModaleViewInQuality')
							.click(
									function() {

										var categoryid = $("#categoryId").val();
										var topicid = $("#topicId").val();
										var lanId = $("#lanId").val();

										$
												.ajax({
													type : "GET",
													url : "/viewKeywordInQuality",
													data : {
														"categorname" : categoryid,
														"topicid" : topicid,
														"lanId" : lanId
													},
													contentType : "application/json",
													success : function(result) {

														$(
																"#keywordViewInKeyword")
																.prop(
																		'disabled',
																		false);
														$(
																'#keywordViewInKeyword')
																.html(result);

													},

													error : function(err) {
														console
																.log("not working. ERROR: "
																		+ JSON
																				.stringify(err));
													}

												});

									});

					/* Here code to view keywored into Domain reviwer */

//					$('#keywordModaleViewInDomain').click(
//							function() {
//
//								var categoryid = $("#categoryId").val();
//								var topicid = $("#topicId").val();
//								var lanId = $("#lanId").val();
//
//								$.ajax({
//									type : "GET",
//									url : "/viewKeywordInDomain",
//									data : {
//										"categorname" : categoryid,
//										"topicid" : topicid,
//										"lanId" : lanId
//									},
//									contentType : "application/json",
//									success : function(result) {
//
//										$('#keywordViewInDomainKeyword').html(
//												result);
//
//									},
//
//									error : function(err) {
//										console.log("not working. ERROR: "
//												+ JSON.stringify(err));
//									}
//
//								});
//
//							});

					$('#videoViewId')
							.click(
									function() {

										var categoryid = $("#categoryId").val();
										var topicid = $("#topicId").val();
										var lanId = $("#lanId").val();

										$
												.ajax({

													type : "GET",
													url : "/viewVideo",
													data : {
														"categorname" : categoryid,
														"topicid" : topicid,
														"lanId" : lanId
													},
													contentType : "application/json",
													success : function(result) {

														// $("#VideoView").prop('disabled',false);
														// $('#VideoView').html(result);

														var res = result;

														source = document
																.getElementById('storedVideoId');
														source.setAttribute(
																'src', res);
														source.setAttribute(
																'type',
																'video/mp4')

														source.play(); // test
																		// playback
																		// of
																		// new
																		// video

														// $('#videoDiv').show()

													},

													error : function(err) {
														console
																.log("not working. ERROR: "
																		+ JSON
																				.stringify(err));
													}

												});

									});

					// here is code for Quality View

					$('#videoViewId')
							.click(
									function() {

										var categoryid = $("#categoryId").val();
										var topicid = $("#topicId").val();
										var lanId = $("#lanId").val();

										$
												.ajax({

													type : "GET",
													url : "/viewVideo",
													data : {
														"categorname" : categoryid,
														"topicid" : topicid,
														"lanId" : lanId
													},
													contentType : "application/json",
													success : function(result) {

														// $("#VideoView").prop('disabled',false);
														// $('#VideoView').html(result);

														var res = result;

														source = document
																.getElementById('storedVideoId');
														source.setAttribute(
																'src', res);
														source.setAttribute(
																'type',
																'video/mp4')

														source.play(); // test
																		// playback
																		// of
																		// new
																		// video

														// $('#videoDiv').show()

													},

													error : function(err) {
														console
																.log("not working. ERROR: "
																		+ JSON
																				.stringify(err));
													}

												});

									});

					// here code outline View

					$('#outlineViewModel').click(
							function() {

								var categoryid = $("#categoryId").val();
								var topicid = $("#topicId").val();
								var lanId = $("#lanId").val();
								$.ajax({

									type : "GET",
									url : "/outlineView",
									data : {
										"categorname" : categoryid,
										"topicid" : topicid,
										"lanId" : lanId
									},
									contentType : "application/json",
									success : function(result) {

										$("#outlineViewResponse").prop(
												'disabled', false);
										$('#outlineViewResponse').html(result);

									},

									error : function(err) {
										console.log("not working. ERROR: "
												+ JSON.stringify(err));
									}

								});

							});

					// Script View Contributor

					$('#viewScriptId').click(
							function() {

								var categoryid = $("#categoryId").val();
								var topicid = $("#topicId").val();
								var lanId = $("#lanId").val();
								$.ajax({

									type : "GET",
									url : "/scriptPdf",
									data : {
										"categorname" : categoryid,
										"topicid" : topicid,
										"lanId" : lanId
									},
									contentType : "application/json",
									success : function(result) {
										var res = result;
										// alert("NEW video path : " + res);
										// //should be a valid path eg:
										// https://example.com/myvideo.mp4

										source = document
												.getElementById('ScriptPdf');
										source.setAttribute('href', res);

										// source.setAttribute('type','video/mp4')
										source.play();

									},

									error : function(err) {
										console.log("not working. ERROR: "
												+ JSON.stringify(err));
									}

								});

							});

					// Contributor Script modelView

					$('#slideModaleView').click(
							function() {

								var categoryid = $("#categoryId").val();
								var topicid = $("#topicId").val();
								var lanId = $("#lanId").val();
								$.ajax({

									type : "GET",
									url : "/sliedPdf",
									data : {
										"categorname" : categoryid,
										"topicid" : topicid,
										"lanId" : lanId
									},
									contentType : "application/json",
									success : function(result) {
										var res = result;
										// alert("NEW video path : " + res);
										// //should be a valid path eg:
										// https://example.com/myvideo.mp4

										source = document
												.getElementById('sliedPdf');
										source.setAttribute('href', res);
										// source.setAttribute('type','video/mp4')

										source.play();

									},

									error : function(err) {
										console.log("not working. ERROR: "
												+ JSON.stringify(err));
									}

								});

							});

					$('#videoModel').on('hidden.bs.modal', function() {
						location.reload();

					});

					$('#videoClick')
							.click(
									function() {
										var categoryid = $("#categoryId").val();
										var topicid = $("#topicId").val();
										var lanId = $("#lanId").val();

										$
												.ajax({

													type : "GET",
													url : "/viewVideo",
													data : {
														"categorname" : categoryid,
														"topicid" : topicid,
														"lanId" : lanId
													},
													contentType : "application/json",
													success : function(result) {

														var res = result;
														source = document
																.getElementById('storedVideoId');
														source.setAttribute(
																'src', res);
														source.setAttribute(
																'type',
																'video/mp4')

													},

													error : function(err) {
														console
																.log("not working. ERROR: "
																		+ JSON
																				.stringify(err));
													}

												});

									});

					$('#VideoStatusAccept').on('hidden.bs.modal', function() {
						location.reload();

					});

					// Quality

					$('#OutlineAccepOrNeedToImprovementQuality').on(
							'hidden.bs.modal', function() {
								location.reload();

							});

					$('#scriptStatusAccept').on('hidden.bs.modal', function() {
						location.reload();

					});

					$('#slideAcceptOrNeedImp').on('hidden.bs.modal',
							function() {
								location.reload();

							});

					$('#VideoAccepOrNeedToImprovementQuality').on(
							'hidden.bs.modal', function() {
								location.reload();

							});

					$('#keywordAccepOrNeedToImprovementQuality').on(
							'hidden.bs.modal', function() {
								location.reload();

							});

					$('#categoryNameList').change(function() {

					});

					// Here is code for category display into category and
					// language

					$('#categoryId')
							.change(
									function() {
										var categoryid = $("#categoryNameList")
												.val();
										var languageid = $("#inputLanguageList")
												.val();

										$
												.ajax({

													type : "GET",
													url : "/loadCategoryAndLanguage",
													data : {
														"id" : categoryid,
														"lanid" : language
													},
													contentType : "application/json",
													success : function(result) {

														var html = '';
														var len = result.length;
														html += '<option value="0">Select language</option>';
														for (var i = 0; i < len; i++) {

															html += '<option value="'
																	+ result[i]
																	+ '">'
																	+ result[i]
																	+ '</option>';
														}
														html += '</option>';

														$("#inputLanguageList")
																.prop(
																		'disabled',
																		false);
														$('#inputLanguageList')
																.html(html);

													},

													error : function(err) {
														console
																.log("not working. ERROR: "
																		+ JSON
																				.stringify(err));
													}

												});

									});
					$( "#categoryname" ).change(function() {
//					$('#categoryname')
//							.on('change',function() {
//											
//										var catgoryid = $(this).find(
//												":selected").val();
										var catgoryid = $(this).val();
										console.log(catgoryid);
										$.ajax({
													type : "GET",
													url : "/listTopicsByCategory",
													data : {
														"id" : catgoryid
													},
													contentType : "application/json",
													success : function(result) {

														var html = '';
														var len = result.length;
														html += '<option value="0">Select Topic</option>';
														for (var i = 0; i < len; i++) {

															html += '<option value="'
																	+ result[i]
																	+ '">'
																	+ result[i]
																	+ '</option>';
														}
														html += '</option>';

//														$("#inputLanguage").prop('disabled',false);
//														$('#inputLanguage').html(html);
														$("#inputTopicName").prop('disabled',false);
														$('#inputTopicName').html(html);

													},
													error : function(err) {
														console.log("not working. ERROR: "+ JSON.stringify(err));
													}
												});
									});
					
					
					$('#inputTopicName').change(function() {
//								alert('here 3');
								var topic = $(this).val();
								var categoryName = $("#categoryname").val();
								$.ajax({
											type : "GET",
											url : "/listLangByCategoryTopic",
											data : {
												"category" : categoryName,
												"topic" : topic
											},
											contentType : "application/json",
											success : function(result) {
												console.log(result);

												var html = '';
												var len = result.length;
												html += '<option value="0">Select language</option>';
												for (var i = 0; i < len; i++) {

													html += '<option value="'
															+ result[i]
															+ '">'
															+ result[i]
															+ '</option>';
												}
												html += '</option>';

												$("#inputLanguage").prop('disabled',false);
												$('#inputLanguage').html(html);
											},
											error : function(err) {
												console.log("not working. ERROR: "+ JSON.stringify(err));
											}
										});

							});

					/* here we write code for calling Topic */

					$('#categoryId')
							.on('change',function() {
										alert('here again');
										var catgoryid = $(this).find(
												":selected").val();
										$
												.ajax({
													type : "GET",
													url : "/loadByCategoryTuturialTopic",
													data : {
														"id" : catgoryid
													},
													contentType : "application/json",
													success : function(result) {

														var html = '';
														var len = result.length;
														html += '<option value="0">Select Topic</option>';
														for (var i = 0; i < len; i++) {
															html += '<option value="'
																	+ result[i]
																	+ '">'
																	+ result[i]
																	+ '</option>';
														}
														html += '</option>';

														$("#inputTopic").prop(
																'disabled',
																false);
														$('#inputTopic').html(
																html);

													},

													error : function(err) {
														console
																.log("not working. ERROR: "
																		+ JSON
																				.stringify(err));
													}

												});

									});

					/* here we write code for calling language */

					$('#categoryId')
							.on('change',function() {
										alert('!!!!');
										var catgoryid = $(this).find(
												":selected").val();
										$
												.ajax({

													type : "GET",
													url : "/loadByCategoryTuturial",
													data : {
														"id" : catgoryid
													},
													contentType : "application/json",
													success : function(result) {

														var html = '';
														var len = result.length;
														html += '<option value="0">Select language</option>';
														for (var i = 0; i < len; i++) {
															html += '<option value="'
																	+ result[i]
																	+ '">'
																	+ result[i]
																	+ '</option>';
														}
														html += '</option>';

														$("#inputLanguage")
																.prop(
																		'disabled',
																		false);
														$('#inputLanguage')
																.html(html);

													},

													error : function(err) {
														console
																.log("not working. ERROR: "
																		+ JSON
																				.stringify(err));
													}

												});

									});

					// chages according to individual table by languge
					$('#preRequsite')
							.change(
									function() {
										alert('show topics');

										var catgoryid = $(this).find(
												":selected").val();
										$
												.ajax({
													type : "GET",
													url : "/loadByCategoryTuturial",
													data : {
														"id" : catgoryid
													},
													contentType : "application/json",
													success : function(result) {

														var html = '';
														var len = result.length;
														html += '<option value="0">Select Topic</option>';
														for (var i = 0; i < len; i++) {
															html += '<option value="'
																	+ result[i]
																	+ '">'
																	+ result[i]
																	+ '</option>';
														}
														html += '</option>';

														$("#inputLanguage1")
																.prop(
																		'disabled',
																		false);
														$('#inputLanguage1')
																.html(html);

													},

													error : function(err) {
														console
																.log("not working. ERROR: "
																		+ JSON
																				.stringify(err));
													}

												});

									});

					$('#inputLanguage1')
							.change(
									function() {

										var catgoryid = $(this).find(
												":selected").val();

										$
												.ajax({
													type : "GET",
													url : "/downloadQuestion",
													data : {
														"id" : catgoryid
													},
													contentType : "application/json",
													success : function(result) {

														var html = '';
														var len = result.length;
														html += '<a href="#">Click To Open</a>';
														for (var i = 0; i < len; i++) {

															html += '<a her="'
																	+ result[i]
																	+ '">'
																	+ '<a href='
																	+ result[i]
																	+ '>'
																	+ result[i]
																	+ '</a>'
																	+ '</option>';

														}
														html += '</option>';

														$("#input").prop(
																'disabled',
																false);

														$('#inputdiv').html(
																html);

													},

													error : function(err) {
														console
																.log("not working. ERROR: "
																		+ JSON
																				.stringify(err));

													}

												});

									});

					/*
					 * master trainer depending on language wet topic
					 */

					$('#inputLanguage')
							.change(
									function() {

										var catgoryid = $(this).find(
												":selected").val();

										$
												.ajax({
													type : "GET",
													url : "/loadByLangugaeTopic",
													data : {
														"id" : catgoryid
													},
													contentType : "application/json",
													success : function(result) {

														var html = '';
														var len = result.length;
														html += '<option value="0">Select Topic</option>';
														for (var i = 0; i < len; i++) {

															html += '<option value="'
																	+ result[i]
																	+ '">'
																	+ result[i]
																	+ '</option>';
														}
														html += '</option>';

														$("#selectLanguageId")
																.prop(
																		'disabled',
																		false);
														$('#selectLanguageId')
																.html(html);

													},

													error : function(err) {
														console
																.log("not working. ERROR: "
																		+ JSON
																				.stringify(err));
													}

												});

									});

					// chages according to individual table by languge

					$('#catId')
							.change(
									function() {

										var catgoryid = $(this).find(
												":selected").val();

										$
												.ajax({
													type : "GET",
													url : "/loadBycategorylanguage",
													data : {
														"id" : catgoryid
													},
													contentType : "application/json",
													success : function(result) {

														var html = '';
														var len = result.length;
														html += '<option value="0">Select language</option>';
														for (var i = 0; i < len; i++) {

															html += '<option value="'
																	+ result[i]
																	+ '">'
																	+ result[i]
																	+ '</option>';
														}
														html += '</option>';

														$("#inputLan").prop(
																'disabled',
																false);
														$('#inputLan').html(
																html);

													},

													error : function(err) {
														console
																.log("not working. ERROR: "
																		+ JSON
																				.stringify(err));
													}

												});

									});

					/* Access topic according to langaueg */

					$('#MasterCategoryId')
							.change(
									function() {

										var catgoryid = $(this).find(
												":selected").val();
										$
												.ajax({

													type : "GET",
													url : "/loadByCategoryByTopic",
													data : {
														"id" : catgoryid
													},
													contentType : "application/json",
													success : function(result) {

														var html = '';
														var len = result.length;
														html += '<option value="0">Select Topic</option>';
														for (var i = 0; i < len; i++) {
															html += '<option value="'
																	+ result[i]
																	+ '">'
																	+ result[i]
																	+ '</option>';
														}
														html += '</option>';

														$("#inputTopic").prop(
																'disabled',
																false);
														$('#inputTopic').html(
																html);

													},

													error : function(err) {
														console
																.log("not working. ERROR: "
																		+ JSON
																				.stringify(err));
													}

												});

									});

					/* load Topic by catgory contributor */

					$('#categoryContributor')
							.change(
									function() {
										var catgoryid = $('#categoryContributor').val();
//										var catgoryid = $(this).find(
//												":selected").val();

										$
												.ajax({

													type : "GET",
													url : "/loadTopicByCategoryContributor",
													data : {
														"id" : catgoryid
													},
													contentType : "application/json",
													success : function(result) {

														html += '<option value="'
																+ result[i]
																+ '">'
																+ result[i]
																+ '</option>';

														var html = '';
														var len = result.length;
														html += '<option value="0">Select Topic</option>';
														for (var i = 0; i < len; i++) {
															html += '<option value="'
																	+ result[i]
																	+ '">'
																	+ result[i]
																	+ '</option>';
														}
														html += '</option>';

														$(
																"#inputTopicContributor")
																.prop(
																		'disabled',
																		false);
														$(
																'#inputTopicContributor')
																.html(html);

													},

													error : function(err) {
														console
																.log("not working. ERROR: "
																		+ JSON
																				.stringify(err));
													}

												});

									});

					/* contributor languages */

					$('#inputTopicContributor')
							.change(
									function() {

										var catgoryid = $(this).find(
												":selected").val();
										$
												.ajax({

													type : "GET",
													url : "/loadLanguageByTopicId",
													data : {
														"id" : catgoryid
													},
													contentType : "application/json",
													success : function(result) {

														var html = '';
														var len = result.length;
														html += '<option value="0">Select Language</option>';
														for (var i = 0; i < len; i++) {
															html += '<option value="'
																	+ result[i]
																	+ '">'
																	+ result[i]
																	+ '</option>';
														}
														html += '</option>';

														$(
																"#inputLanguageContributor")
																.prop(
																		'disabled',
																		false);
														$(
																'#inputLanguageContributor')
																.html(html);

													},

													error : function(err) {
														console
																.log("not working. ERROR: "
																		+ JSON
																				.stringify(err));
													}

												});

									});

					/*
					 * Access language depending on topic contributer
					 */

					$('#inputTopic')
							.change(
									function() {
//										alert('here');
										var catgoryid = $(this).find(
												":selected").val();
										$
												.ajax({
													type : "GET",
													url : "/loadlanguage",
													data : {
														"id" : catgoryid
													},
													contentType : "application/json",
													success : function(result) {

														var html = '';
														var len = result.length;
														html += '<option value="0">Select Languge</option>';
														for (var i = 0; i < len; i++) {
															html += '<option value="'
																	+ result[i]
																	+ '">'
																	+ result[i]
																	+ '</option>';
														}
														html += '</option>';

														$("#inputLanguage")
																.prop(
																		'disabled',
																		false);
														$('#inputLanguage')
																.html(html);

													},

													error : function(err) {
														console
																.log("not working. ERROR: "
																		+ JSON
																				.stringify(err));

													}

												});

									});

					$('#outlineId')
							.click(
									function() {
										$(this).toggle();
										$('#editOutline').toggle();
										
										var saveInfo = editor.getData();
										console.log("******************");
										console.log(saveInfo);
										console.log("******************");
										var keywordArea = $("#keyword").val();
										var categoryid = $("#categoryId").val();
										var topicid = $("#topicId").val();
										var lanId = $("#lanId").val();
										localStorage.setItem(
												"upload_outline_msg",
												"Outline updated.");
										editor.isReadOnly = true;

										$
												.ajax({
													type : "GET",
													url : "/outline",
													data : {
														"saveOutline" : saveInfo,
														"id" : keywordArea,
														"categorname" : categoryid,
														"topicid" : topicid,
														"lanId" : lanId
													},
													contentType : "application/json",
													success : function(result) {
														// $("#statusOutline").prop('disabled',
														// false);
														var msg = 'Outline updated successfully.'
														// $('#statusOutline').html(html);
														$('#statusOutlineC')
																.addClass(
																		'd-block');
														$('#statusOutlineC')
																.html(msg);

													},
													error : function(err) {
														console
																.log("not working. ERROR: "
																		+ JSON
																				.stringify(err));
														var msg = 'Error in updating outline.'
														// $('#statusOutline').html(html);
														$('#statusOutlineC')
																.addClass(
																		'd-block');
														$('#statusOutlineC')
																.addClass(
																		'alert-danger');

														$('#statusOutlineC')
																.html(msg);

													}

												});

									});

					$('#editOutline').click(function() {
						$(this).toggle();
						$('outlineId').toggle();

						editor.isReadOnly = false;
						// outlineId
						$('#outlineId').show();
						$("#outlineId").html("Save changes");

					});

					$('#editKeyword').click(function() {
						$(this).toggle();
						$('keywordId').toggle();
						$('#keyword').prop('readonly', false);
						// outlineId
						$('#keywordId').show();
						$("#keywordId").html("Save changes");

					});

					/* Save keyWord information into table */

					$('#keywordId').click(
							function() {
								$(this).toggle();
								$('#editKeyword').toggle();
								var keywordArea = $("#keyword").val();
								var categoryid = $("#categoryId").val();
								var topicid = $("#topicId").val();
								var lanId = $("#lanId").val();
								$('#keyword').prop('readonly', true);
								$.ajax({
									type : "GET",
									url : "/keyword",
									data : {
										"id" : keywordArea,
										"categorname" : categoryid,
										"topicid" : topicid,
										"lanId" : lanId
									},
									contentType : "application/json",
									success : function(result) {
										showStatus(SUCCESS,
												result);
//										$("#statuskeyword").prop('disabled',
//												false);
//										$('#statuskeyword').html(result);

									},

									error : function(err) {
										console.log("not working. ERROR: "
												+ JSON.stringify(err));
										var result = "Error"; 
										showStatus(ERROR,
												result);
									}

								});

							});

					/*
					 * Here is code for save script
					 */

					$('#scriptId')
							.click(
									function() {

										// here1
										var categoryid = $("#categoryId").val();
										var topicid = $("#topicId").val();
										var lanId = $("#lanId").val();

										var form = $('#upload-file-form-script')[0];
										var formData = new FormData(form);
//										alert(form);
										console.log(form);
										console.log(form[0]);

										formData.append('categoryid',categoryid);
										formData.append('topicid', topicid);
										formData.append('lanId', lanId);

										$.ajax({
											type : "POST",
											url : "/scriptUpload",
											data : formData,
											enctype : 'multipart/form-data',
											processData : false,
											contentType : false,
											cache : false,
											success : function(result) {
//												$("#statusofScript").prop('disabled',true);
//												$('#statusofScript').html(result[2]);
												$('#viewScript').html(result[0]);
//												source = document.getElementById('storedVideoId');
//												source.setAttribute('src',result[1]);
												var result = "Script updated successfully";
												showStatus(SUCCESS,result);
												$('.upload-status').hide();
											},

											error : function(err) {
												console.log("not working. ERROR: "+ JSON.stringify(err));
												var result = "Error";
												showStatus(ERROR,result);
											}
										});

									});

					/*
					 * here we write code for slide
					 */

					$('#slideId').click(
							function() {

								var categoryid = $("#categoryId").val();
								var topicid = $("#topicId").val();
								var lanId = $("#lanId").val();

								var form = $('#upload-file-form')[0];
								var formData = new FormData(form);

								formData.append('categoryid', categoryid);
								formData.append('topicid', topicid);
								formData.append('lanId', lanId);

								console.log(formData);
								
								$.ajax({
									type : "POST",
									url : "/slideUpload",
									data : formData,
									enctype : 'multipart/form-data',
									processData : false,
									contentType : false,
									cache : false,
									success : function(result) {
//										$("#statusofSlide").prop('disabled',true);
//										$('#statusofSlide').html(result[2]);

										$('#sliedPdf').html(result[0]);
										$("#sliedPdf").prop('href', result[1]);
										var result = "Slide uploaded successfully";
										showStatus(SUCCESS,result);

									},

									error : function(err) {console.log("not working. ERROR: "+ JSON.stringify(err));
									var result = "Slide uploaded successfully";
									showStatus(SUCCESS,result);
									}

								});

							});

					
					
					
					
			/*		Here is code for graphics*/
					

					$('#graphicsId').click(
							function() {

								var categoryid = $("#categoryId").val();
								var topicid = $("#topicId").val();
								var lanId = $("#lanId").val();

								var form = $('#upload-file-form-graphics')[0];
								var formData = new FormData(form);
								console.log(formData);
								
								formData.append('categoryid', categoryid);
								formData.append('topicid', topicid);
								formData.append('lanId', lanId);
								
								
								

								$.ajax({
									type : "POST",
									url : "/graphicsUpload",
									data : formData,
									enctype : 'multipart/form-data',
									processData : false,
									contentType : false,
									cache : false,
									success : function(result) {
//										$("#statusofSlide").prop('disabled',true);
//										$('#statusofSlide').html(result[2]);
										
//										alert("12345hi");
										
										$('#sliedPdf').html(result[0]);
										$("#sliedPdf").prop('href', result[1]);
										var result = "Graphics uploaded successfully";
										showStatus(SUCCESS,result);

									},

									error : function(err) {console.log("not working. ERROR: "+ JSON.stringify(err));
									var result = "Graphics uploaded successfully";
									showStatus(SUCCESS,result);
									}

								});

							});

					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					/* video for thumnail and video */

					$('#videoId')
							.click(
									function() {
//										alert('videoId');
										var categoryid = $("#categoryId").val();
										var topicid = $("#topicId").val();
										var lanId = $("#lanId").val();

										var form = $('#upload-file-form-video')[0];
										var formData = new FormData(form);

										formData.append('categoryid',
												categoryid);
										formData.append('topicid', topicid);
										formData.append('lanId', lanId);

										$
												.ajax({
													type : "POST",
													url : "/videoUpload",
													data : formData,
													enctype : 'multipart/form-data',
													processData : false,
													contentType : false,
													cache : false,
													success : function(result) {

														$("#statusofVideo")
																.prop(
																		'disabled',
																		true);
														$('#statusofVideo')
																.html(result[2]);

														source = document
																.getElementById('storedVideoId');
														source.setAttribute(
																'src',
																result[1]);
														source.setAttribute(
																'type',
																'video/mp4')

													},

													error : function(err) {
														console
																.log("not working. ERROR: "
																		+ JSON
																				.stringify(err));
													}

												});

									});

					$('#PrerequisiteVideoId')
							.click(
									function() {

										var categoryid = $("#categoryId").val();
										var topicid = $("#topicId").val();
										var lanId = $("#lanId").val();

										var form = $('#upload-file-form-prerequisite')[0];
										var formData = new FormData(form);

										formData.append('categoryid',
												categoryid);
										formData.append('topicid', topicid);
										formData.append('lanId', lanId);

										$
												.ajax({
													type : "POST",
													url : "/prerequisite",
													data : formData,
													enctype : 'multipart/form-data',
													processData : false,
													contentType : false,
													cache : false,
													success : function(result) {

														$(
																"#statusofprerequisite")
																.prop(
																		'disabled',
																		true);
														$(
																'#statusofprerequisite')
																.html(result);

													},

													error : function(err) {
														console
																.log("not working. ERROR: "
																		+ JSON
																				.stringify(err));
													}

												});

									});

					$('#myCheck').click(
							function() {

								var checkbox = $("#myCheck").val();

								$.ajax({

									type : "GET",
									url : "/keyword",
									data : {
										"id" : keywordArea
									},
									contentType : "application/json",
									success : function(result) {
										$("#statuskeyword").prop('disabled',
												false);
										$('#statuskeyword').html(result);

									},

									error : function(err) {
										console.log("not working. ERROR: "
												+ JSON.stringify(err));
									}

								});

							});

					/* here calling approve button for contributorvideoUpload */

					$('.approveContributor').click(
							function() {
								// use localStorage to retrieve information on
								// page refresh
								localStorage
										.setItem('activeTab', "Contributer");

								var contributionId = $(this).val();

								$.ajax({
									type : "GET",
									url : "/addContributerRoleById",
									data : {
										"id" : contributionId
									},
									contentType : "application/json",
									success : function(result) {

										$("#statusContributor").prop(
												'disabled', false);

										localStorage.setItem('msg', result);
										location.reload();

									},

									error : function(err) {
										console.lo3g("not working. ERROR: "
												+ JSON.stringify(err));
									}

								});

							});

					// Here is code for Admin Reviwer Approve

					$('.approveAdmin').click(
							function() {
								// use localStorage to retrieve information on
								// page refresh
								localStorage.setItem('activeTab', "Admin");
								var contributionId = $(this).val();

								$.ajax({
									type : "GET",
									url : "/addAdminRoleById",
									data : {
										"id" : contributionId
									},
									contentType : "application/json",
									success : function(result) {

										$("#statusAdmin").prop('disabled',
												false);
										localStorage.setItem('msg', result);

										$('#ContributerPage').on(
												'hidden.bs.modal', function() {

													location.reload();
												});

										location.reload();
									},

									error : function(err) {
										console.lo3g("not working. ERROR: "
												+ JSON.stringify(err));
									}

								});

							});

					// Here is code for Quality Reviweer

					$('.approveQuality').click(
							function() {
								// use localStorage to retrieve information on
								// page refresh
								localStorage.setItem('activeTab', "Quality");
								var contributionId = $(this).val();

								$.ajax({
									type : "GET",
									url : "/addQualityRoleById",
									data : {
										"id" : contributionId
									},
									contentType : "application/json",
									success : function(result) {

										$("#statusQuality").prop('disabled',
												false);
										$('#statusQuality').html(result);
										localStorage.setItem('msg', result);

										$('#ContributerPage').on(
												'hidden.bs.modal', function() {

													location.reload();

												});

										location.reload();

									},

									error : function(err) {
										console.lo3g("not working. ERROR: "
												+ JSON.stringify(err));
									}

								});

							});

					// Here is code for Master Trainer

					$('.approvemaster').click(
							function() {
								// use localStorage to retrieve information on
								// page refresh
								localStorage.setItem('activeTab',
										"MasterTrainer");

								var contributionId = $(this).val();

								$.ajax({
									type : "GET",
									url : "/addMasterRoleById",
									data : {
										"id" : contributionId
									},
									contentType : "application/json",
									success : function(result) {

										$("#statusMaster").prop('disabled',
												false);
										$('#statusMaster').html(result);
										localStorage.setItem('msg', result);

										$('#ContributerPage').on(
												'hidden.bs.modal', function() {

													location.reload();

												});

										location.reload();

									},

									error : function(err) {
										console.lo3g("not working. ERROR: "
												+ JSON.stringify(err));
									}

								});

							});

					// here is code for approve DomainReviwer By admin

					$('.approveDomain').click(
							function() {
								// use localStorage to retrieve information on
								// page refresh
								localStorage.setItem('activeTab', "Domain");

								var contributionId = $(this).val();

								$.ajax({
									type : "GET",
									url : "/addDomainRoleById",
									data : {
										"id" : contributionId
									},
									contentType : "application/json",
									success : function(result) {

										$("#statusDomain").prop('disabled',
												false);
										$('#statusDomain').html(result);
										localStorage.setItem('msg', result);

										$('#ContributerPage').on(
												'hidden.bs.modal', function() {

													location.reload();

												});

										location.reload();

									},

									error : function(err) {
										console.lo3g("not working. ERROR: "
												+ JSON.stringify(err));
									}

								});

							});

					$('#rejectContributionId').click(
							function() {

								var contributionId = $("#contributorId").val();
//								alert(contributionId);

								$.ajax({
									type : "GET",
									url : "/rejectContributorById",
									data : {
										"id" : contributionId
									},
									contentType : "application/json",
									success : function(result) {

										$("#statusContributor").prop(
												'disabled', false);
										$('#statusContributor').html(result);

									},

									error : function(err) {
										console.log("not working. ERROR: "
												+ JSON.stringify(err));
									}

								});

							});

					/* load By Contributor user only contributor assign from */

					$('#contributorId')
							.on(
									'change',
									function() {

										var userContributor = $(this).find(
												':selected').val();
										console.log(userContributor);
										$
												.ajax({
													type : "GET",
													url : "/loadLanguageByUser",
													data : {
														"id" : userContributor
													},
													contentType : "application/json",
													success : function(result) {

														console.log(result);
														var html = '';
														var len = result.length;
														html += '<option value="0">Select Language</option>';
														for (var i = 0; i < len; i++) {
															html += '<option value="'
																	+ result[i]
																	+ '">'
																	+ result[i]
																	+ '</option>';
														}
														html += '</option>';

														$("#lanId").prop(
																'disabled',
																false);
														$('#lanId').html(html);

													},

													error : function(err) {
														console
																.log("not working. ERROR: "
																		+ JSON
																				.stringify(err));
													}
												});

									});

					$('#lanId')
							.click(
									function() {
										var languageName = $(
												"#option :selected").text();

										$
												.ajax({
													type : "GET",
													url : "/loadCategoryByLanguage",
													data : {
														"id" : languageName
													},
													contentType : "application/json",
													success : function(result) {

														var html = '';
														var len = result.length;
														html += '<option value="0">Select Category</option>';
														for (var i = 0; i < len; i++) {
															html += '<option value="'
																	+ result[i]
																	+ '">'
																	+ result[i]
																	+ '</option>';
														}
														html += '</option>';

														$(
																"#catgoryByContributor")
																.prop(
																		'disabled',
																		false);
														$(
																'#catgoryByContributor')
																.html(html);

													},

													error : function(err) {
														console
																.log("not working. ERROR: "
																		+ JSON
																				.stringify(err));
													}
												});

									});

					$('#catgoryByContributor').on(
							'change',
							function() {
								var category = $(this).find("option:selected")
										.val();
								var languageName = $('#lanId').val();
								var userName = $('#contributorId').val();

								$.ajax({
									type : "GET",
									url : "/loadTopicByCategory",
									data : {
										"id" : category,
										"lanId" : languageName,
										"userName" : userName
									},
									contentType : "application/json",
									success : function(result) {

										var html = '';
										var len = result.length;

										for (var i = 0; i < len; i++) {
											html += '<option value="'
													+ result[i] + '">'
													+ result[i] + '</option>';
										}
										html += '</option>';

										$("#inputTopic")
												.prop('disabled', false);
										$('#inputTopic').html(html);

									},
									error : function(err) {
										console.log("not working. ERROR: "
												+ JSON.stringify(err));
									}
								});

							});

					// here write code for keyword view //add content form

					$('#keywordModaleView').click(
							function() {

								var categoryid = $("#categoryId").val();
								var topicid = $("#topicId").val();
								var lanId = $("#lanId").val();

								$.ajax({
									type : "GET",
									url : "/viewKeyword",
									data : {
										"categorname" : categoryid,
										"topicid" : topicid,
										"lanId" : lanId
									},
									contentType : "application/json",
									success : function(result) {

										$("#keywordView").prop('disabled',
												false);
										$('#keywordView').html(result);

									},

									error : function(err) {
										console.log("not working. ERROR: "
												+ JSON.stringify(err));
									}

								});

							});

					// Here is Code for Quality Review keyword View

					$('#keywordModaleViewInQuality')
							.click(
									function() {

										var categoryid = $("#categoryId").val();
										var topicid = $("#topicId").val();
										var lanId = $("#lanId").val();

										$
												.ajax({
													type : "GET",
													url : "/viewKeywordInQuality",
													data : {
														"categorname" : categoryid,
														"topicid" : topicid,
														"lanId" : lanId
													},
													contentType : "application/json",
													success : function(result) {

														$(
																"#keywordViewInKeyword")
																.prop(
																		'disabled',
																		false);
														$(
																'#keywordViewInKeyword')
																.html(result);

													},

													error : function(err) {
														console
																.log("not working. ERROR: "
																		+ JSON
																				.stringify(err));
													}

												});

									});

					/* Here code to view keywored into Domain reviwer */

					$('#keywordModaleViewInDomain').click(
							function() {

								var categoryid = $("#categoryId").val();
								var topicid = $("#topicId").val();
								var lanId = $("#lanId").val();

								$.ajax({
									type : "GET",
									url : "/viewKeywordInDomain",
									data : {
										"categorname" : categoryid,
										"topicid" : topicid,
										"lanId" : lanId
									},
									contentType : "application/json",
									success : function(result) {

										$('#keywordViewInDomainKeyword').html(
												result);

									},

									error : function(err) {
										console.log("not working. ERROR: "
												+ JSON.stringify(err));
									}

								});

							});

					$('#videoViewId')
							.click(
									function() {
										var categoryid = $("#categoryId").val();
										var topicid = $("#topicId").val();
										var lanId = $("#lanId").val();

										$
												.ajax({

													type : "GET",
													url : "/viewVideo",
													data : {
														"categorname" : categoryid,
														"topicid" : topicid,
														"lanId" : lanId
													},
													contentType : "application/json",
													success : function(result) {
														var res = result;

														source = document
																.getElementById('storedVideoId');
														source.setAttribute(
																'src', res);
														source.setAttribute(
																'type',
																'video/mp4')
													},

													error : function(err) {
														console
																.log("not working. ERROR: "
																		+ JSON
																				.stringify(err));
													}

												});

									});

					// here is code for Quality View

					$('#videoViewId')
							.click(
									function() {
										var categoryid = $("#categoryId").val();
										var topicid = $("#topicId").val();
										var lanId = $("#lanId").val();

										$
												.ajax({

													type : "GET",
													url : "/viewVideo",
													data : {
														"categorname" : categoryid,
														"topicid" : topicid,
														"lanId" : lanId
													},
													contentType : "application/json",
													success : function(result) {
														var res = result;

														source = document
																.getElementById('storedVideoId');
														source.setAttribute(
																'src', res);
														source.setAttribute(
																'type',
																'video/mp4')
													},

													error : function(err) {
														console
																.log("not working. ERROR: "
																		+ JSON
																				.stringify(err));
													}

												});

									});

					// Script View Contributor

					$('#viewScript')
							.click(
									function() {

										var categoryid = $("#categoryId").val();
										var topicid = $("#topicId").val();
										var lanId = $("#lanId").val();
										$
												.ajax({

													type : "GET",
													url : "/scriptPdf",
													data : {
														"categorname" : categoryid,
														"topicid" : topicid,
														"lanId" : lanId
													},
													contentType : "application/json",
													success : function(result) {
														var res = result;
														source = document
																.getElementById('viewScript');
														source.setAttribute(
																'href', res);

														var win = window.open(
																res, '_blank');
														if (win) {
															// Browser has
															// allowed it to be
															// opened
															win.focus();
														} else {
															// Browser has
															// blocked it
//															alert('Please allow popups for this website');
														}
													},

													error : function(err) {
//														alert('failed');
														console
																.log("not working. ERROR: "
																		+ JSON
																				.stringify(err));
													}

												});

									});

					// Contributor Script modelView

					$('#slideModaleView').click(
							function() {

								var categoryid = $("#categoryId").val();
								var topicid = $("#topicId").val();
								var lanId = $("#lanId").val();
								$.ajax({

									type : "GET",
									url : "/sliedPdf",
									data : {
										"categorname" : categoryid,
										"topicid" : topicid,
										"lanId" : lanId
									},
									contentType : "application/json",
									success : function(result) {
										var res = result;
										source = document
												.getElementById('sliedPdf');
										source.setAttribute('href', res);
									},

									error : function(err) {
										console.log("not working. ERROR: "
												+ JSON.stringify(err));
									}

								});

							});

					// here is code for keyword accept or need to improvement
//					$('#AcceptOrNeedToImprovemenetByDomain').change(
					$('#AcceptOrNeedToImprovemenetByDomain').click(
							function() {
										var categoryid = $("#categoryId").val();
										var topicid = $("#topicId").val();
										var lanId = $("#lanId").val();

										var vals = $("#KeywordAcceptDomain").val();

										if (vals === '0') {

//											$('#keywordNeedImprovement').css({
//												'visibility' : 'hidden'
//											});

											alert("Select Accept Or Need To Improvement");

										} else if (vals === '1') {

//											$('#keywordNeedImprovement').css({
//												'visibility' : 'hidden'
//											});
//
//											alert("Hello");

											$.ajax({
														type : "GET",
														url : "/acceptkeywordByDomain",
														data : {
															"categorname" : categoryid,
															"topicid" : topicid,
															"lanId" : lanId
														},
														contentType : "application/json",
														success : function(
																result) {
															showStatus(SUCCESS,result);
//															$("#statusKeywordByDomain").prop('disabled',false);
//															$('#statusKeywordByDomain').html(result);

														},

														error : function(err) {
															console.lo3g("not working. ERROR: "+ JSON.stringify(err));
															result = "Error";
															showStatus(ERROR,result);
														}

													});

										} else if (vals === '2') {

											$('#keywordNeedImprovement').css({
												'visibility' : 'visible'
											});

											var msg = $("#keywordCommentMsg")
													.val();

											$.ajax({
														type : "GET",
														url : "/needToImpKeywordByDomain",
														data : {
															"categorname" : categoryid,
															"topicid" : topicid,
															"lanId" : lanId,
															'msg' : msg
														},
														contentType : "application/json",

														success : function(
																result) {

//															$("#statusKeywordByDomain").prop('disabled',false);
//															$('#statusKeywordByDomain').html(result);
															showStatus(SUCCESS,result);
														},

														error : function(err) {
															console.log("not working. ERROR: "+ JSON.stringify(err));
															result = "Error";
															showStatus(ERROR,result);
														}

													});
										}

									});

					// Display comment box for need to improvemnet on outline

					// $('#outlineAcceptOtrNeedImp').click(function() {
					$(".select-review-feedback").change(function() {
						var val = $(this).val();
						if (val == '2') {
							$('.textarea-comment').show();
						} else {
							$('.textarea-comment').hide();
						}

						// var vals = $("#outlineAcceptOtrNeedImp").val();
						//
						// if (vals === '0') {
						//
						// $('#OutlineNeedImp').css({
						// 'visibility' : 'hidden'
						// });
						//
						// } else if (vals === '1') {
						//
						// $('#OutlineNeedImp').css({
						// 'visibility' : 'hidden'
						// });
						//
						// } else if (vals === '2') {
						//
						// $('#OutlineNeedImp').css({
						// 'visibility' : 'visible'
						// });
						// }

					});

					$('#outlineAcceptOrNeedToImpClick')
							.click(
									function() {

										var categoryid = $("#categoryId").val();
										var topicid = $("#topicId").val();
										var lanId = $("#lanId").val();

										var vals = $("#outlineAcceptOtrNeedImp")
												.val();

										if (vals === '0') {

											// $('#OutlineNeedImp').css({
											// 'visibility' : 'hidden'
											// });

											alert("Please Select Accept Or Need To Improvement");

										} else if (vals === '1') {

											// $('#OutlineNeedImp').css({
											// 'visibility' : 'hidden'
											// });

											$
													.ajax({
														type : "GET",
														url : "/acceptOutlineByDomain",
														data : {
															"categorname" : categoryid,
															"topicid" : topicid,
															"lanId" : lanId
														},
														contentType : "application/json",
														success : function(
																result) {
															// $("#statusOutlineByDomain").prop('disabled',false);
															// $('#statusOutlineByDomain').html(result);
															showStatus(SUCCESS,
																	result);
														},

														error : function(err) {
															console
																	.log("not working. ERROR: "
																			+ JSON
																					.stringify(err));
															var result = 'Error occured while submitting outline review feedback.';
															showStatus(ERROR,result);
														}
													});

										} else if (vals === '2') {
											// $('#OutlineNeedImp').css({
											// 'visibility' : 'visible'
											// });
											var msg = $("#msgCommentOutline")
													.val();
											$
													.ajax({
														type : "GET",
														url : "/needToImpOutlineByDomain",
														data : {
															"categorname" : categoryid,
															"topicid" : topicid,
															"lanId" : lanId,
															'msg' : msg
														},
														contentType : "application/json",
														success : function(
																result) {
															showStatus(SUCCESS,result);
															// $("#statusOutlineByDomain").prop('disabled',false);
															// $('#statusOutlineByDomain').html(result);
														},

														error : function(err) {
															console.log("not working. ERROR: "+ JSON.stringify(err));
															result = 'Error occured while submitting outline review feedback.';
															showStatus(ERROR,result);
														}
													});
										}

									});

					// here is code for Script for domain

//					$('#scriptAccept').click(function() {
					$('#scriptAccept').change(function() {

						var vals = $("#scriptAccept").val();
						
						if (vals === '2') {
							$('#scriptNeedImprovement').show();
						}else{
							$('#scriptNeedImprovement').hide();
						}

//						if (vals === '0') {
//							$('#scriptNeedImprovement').css({
//								'visibility' : 'hidden'
//							});
//						} else if (vals === '1') {
//
//							$('#scriptNeedImprovement').css({
//								'visibility' : 'hidden'
//							});
//
//						} else if (vals === '2') {
//
//							$('#scriptNeedImprovement').css({
//								'visibility' : 'visible'
//							});
//
//						}

					});

					$('#VideoAccept').click(function() {

						var vals = $(this).find(":selected").val();

						if (vals === '0') {
							$('#videoNeedImprovement').css({
								'visibility' : 'hidden'
							});

						} else if (vals === '1') {

							$('#videoNeedImprovement').css({
								'visibility' : 'visible'
							});

						}

					});

//					$('#VideoAcceptAdmin').click(function() {
					$('#VideoAcceptAdmin').change(function() {

						var vals = $('#VideoAcceptAdmin').val();

						if (vals === '2') {
							$('#videoNeedImprovement').show();
						}else{
							$('#videoNeedImprovement').hide();
						}
//						if (vals === '0') {
//							$('#videoNeedImprovement').css({
//								'visibility' : 'hidden'
//							});
//
//						} else if (vals === '1') {
//
//							$('#videoNeedImprovement').css({
//								'visibility' : 'hidden'
//							});
//
//							l
//
//						} else if (vals === '2') {
//
//							$('#videoNeedImprovement').css({
//								'visibility' : 'visible'
//							});
//
//						}

					});

					// Display domain Outline

					$('#outlineViewModelDomain').click(
							function() {

								var categoryid = $("#categoryId").val();
								var topicid = $("#topicId").val();
								var lanId = $("#lanId").val();
								$.ajax({

									type : "GET",
									url : "/outlineViewDomain",
									data : {
										"categorname" : categoryid,
										"topicid" : topicid,
										"lanId" : lanId
									},
									contentType : "application/json",
									success : function(result) {

										$('#outlineViewResponseDomain').val(
												result)

									},

									error : function(err) {
										console.log("not working. ERROR: "
												+ JSON.stringify(err));
									}

								});

							});

					/* View Script from domain */

					$('#viewScriptIdDomain')
							.click(
									function() {

										var categoryid = $("#categoryId").val();
										var topicid = $("#topicId").val();
										var lanId = $("#lanId").val();

										$
												.ajax({
													type : "get",
													url : "/scriptPdfDomain",
													data : {
														"categorname" : categoryid,
														"topicid" : topicid,
														"lanId" : lanId
													},
													contentType : "application/json",
													success : function(result) {
														var res = result;

														source = document
																.getElementById('scriptPdfDomain');
														source.setAttribute(
																'href', res);

													},

													error : function(err) {
														console
																.log("not working. ERROR: "
																		+ JSON
																				.stringify(err));
													}

												});

									});

					/* view Video By Domain */

					$('#videoViewIdDomain')
							.click(
									function() {

										var categoryid = $("#categoryId").val();
										var topicid = $("#topicId").val();
										var lanId = $("#lanId").val();

										$
												.ajax({

													type : "GET",
													url : "/viewVideoDomain",
													data : {
														"categorname" : categoryid,
														"topicid" : topicid,
														"lanId" : lanId
													},
													contentType : "application/json",
													success : function(result) {

														var res = result;

														source = document
																.getElementById('storedVideoIdDomain');
														source.setAttribute(
																'src',
																"http://localhost:8081/"
																		+ res);
														source.setAttribute(
																'type',
																'video/mp4')

													},

													error : function(err) {
														console
																.log("not working. ERROR: "
																		+ JSON
																				.stringify(err));
													}

												});

									});

					/* Here is code for comment on componenet outline */

					$('#submitCommentId')
							.click(
									function() {

										var categoryid = $("#categoryId").val();
										var topicid = $("#topicId").val();
										var lanId = $("#lanId").val();
										var commentOutlineMsg = $(
												"#msgCommentOutline").val();

										$
												.ajax({

													type : "GET",
													url : "/commentOnOutline",
													data : {
														"categorname" : categoryid,
														"topicid" : topicid,
														"lanId" : lanId,
														"commentOutlineMsg" : commentOutlineMsg,
													},
													contentType : "application/json",
													success : function(result) {
														$("#saveComment").prop(
																'disabled',
																false);
														$('#saveComment').html(
																result);

													},

													error : function(err) {
														console
																.log("not working. ERROR: "
																		+ JSON
																				.stringify(err));
													}

												});

									});

					/* Here is code for comment on componenet Video Domain */

					$('#videoAcceptOrNeedToImprovemenet').click(
							function() {

								var categoryid = $("#categoryId").val();
								var topicid = $("#topicId").val();
								var lanId = $("#lanId").val();
								var videoCommentMsg = $("#videoCommentMsg")
										.val();

								$.ajax({

									type : "GET",
									url : "/commentOnVideo",
									data : {
										"categorname" : categoryid,
										"topicid" : topicid,
										"lanId" : lanId,
										"videoCommentMsg" : videoCommentMsg
									},
									contentType : "application/json",
									success : function(result) {

										$("#saveCommentVideo").prop('disabled',
												false);
										$('#saveCommentVideo').html(result);

									},

									error : function(err) {
										console.log("not working. ERROR: "
												+ JSON.stringify(err));
									}

								});

							});

					/* Here is code for admin Video */

					$('#videoViewAdmin')
							.click(
									function() {
										var categoryid = $("#categoryId").val();
										var topicid = $("#topicId").val();
										var lanId = $("#lanId").val();

										$
												.ajax({

													type : "GET",
													url : "/viewVideoAdmin",
													data : {
														"categorname" : categoryid,
														"topicid" : topicid,
														"lanId" : lanId
													},
													contentType : "application/json",
													success : function(result) {

														var res = result;

														source = document
																.getElementById('storedVideoId');
														source.setAttribute(
																'src',
																"http://localhost:8081/"
																		+ res);
														source.setAttribute(
																'type',
																'video/mp4')
														source.play();

													},

													error : function(err) {
														console
																.log("not working. ERROR: "
																		+ JSON
																				.stringify(err));
													}

												});

									});

					$('#videoViewIdAdmin')
							.click(
									function() {
										var categoryid = $("#categoryId").val();
										var topicid = $("#topicId").val();
										var lanId = $("#lanId").val();

										$
												.ajax({

													type : "GET",
													url : "/viewVideoAdmin",
													data : {
														"categorname" : categoryid,
														"topicid" : topicid,
														"lanId" : lanId
													},
													contentType : "application/json",
													success : function(result) {

														var res = result;

														source = document
																.getElementById('storedVideoId');
														source.setAttribute(
																'src',
																"http://localhost:8081/"
																		+ res);
														source.setAttribute(
																'type',
																'video/mp4')

													},

													error : function(err) {
														console
																.log("not working. ERROR: "
																		+ JSON
																				.stringify(err));
													}

												});

									});

					/* here is code for video accepet or need to improvement */

					$('#videoAcceptOrNeedToImprovemenetByAdmin')
							.click(
									function() {

										var categoryid = $("#categoryId").val();
										var topicid = $("#topicId").val();
										var lanId = $("#lanId").val();

										var vals = $("#VideoAcceptAdmin").val();

										if (vals == '0') {
											$('#msgVideoCommentByAdmin').css({
												'visibility' : 'hidden'
											});

											alert("Select Accept Or Need To Improvement");

										} else if (vals == '1') {

											$('#msgVideoCommentByAdmin').css({
												'visibility' : 'hidden'
											});

											$
													.ajax({

														type : "GET",
														url : "/acceptAdminVideo",
														data : {
															"categorname" : categoryid,
															"topicid" : topicid,
															"lanId" : lanId
														},
														contentType : "application/json",
														success : function(
																result) {

															$(
																	"#statusVideoByAdmin")
																	.prop(
																			'disabled',
																			false);
															$(
																	'#statusVideoByAdmin')
																	.html(
																			result);
															showStatus(SUCCESS, result);

														},

														error : function(err) {
															console
																	.log("not working. ERROR: "
																			+ JSON
																					.stringify(err));
															result = "Error";
															showStatus(ERROR, result);
														}

													});

										} else if (vals == '2') {

											$('#msgVideoCommentByAdmin').css({
												'visibility' : 'visible'
											});

											var msg = $(
													"#msgVideoCommentByAdmin")
													.val();

//											alert("mse admin player" + msg);

											$
													.ajax({

														type : "GET",
														url : "/needToImprovemenetByAdmin",
														data : {
															"categorname" : categoryid,
															"topicid" : topicid,
															"lanId" : lanId,
															"msg" : msg
														},
														contentType : "application/json",
														success : function(
																result) {

															$(
																	"#statusVideoByAdmin")
																	.prop(
																			'disabled',
																			false);
															$(
																	'#statusVideoByAdmin')
																	.html(
																			result);
															
															showStatus(SUCCESS, result);

														},

														error : function(err) {
															console
																	.lo3g("not working. ERROR: "
																			+ JSON
																					.stringify(err));
															result = "Error";
															showStatus(ERROR, result);
														}

													});

										}

									});

					/*
					 * here is code for domain review Video Acdept or Need To
					 * improvemenet
					 */

//					$('#VideoAcceptDomain').click(function() {
					$('#VideoAcceptDomain').change(function() {

						var vals = $("#VideoAcceptDomain").val();

						if (vals === '2') {
							$('#videoNeedImprovement').show();
						}else{
							$('#videoNeedImprovement').hide();
						}
//						if (vals === '0') {
//							$('#videoNeedImprovement').css({
//								'visibility' : 'hidden'
//							});
//						} else if (vals === '1') {
//							$('#videoNeedImprovement').css({
//								'visibility' : 'hidden'
//							});
//
//						} else if (vals === '2') {
//
//							$('#videoNeedImprovement').css({
//								'visibility' : 'visible'
//							});
//
//						}

					});

					/* Here is code keywod accept or need to improvement */
//					$('#KeywordAcceptDomain').click(function() {
					$('#KeywordAcceptDomain').change(function() {
//						alert('HERE');
						var vals = $("#KeywordAcceptDomain").val();
						if (vals === '2'){
							$('#keywordNeedImprovement').show();
						}

//						if (vals === '0') {
//							$('#keywordNeedImprovement').css({
//								'visibility' : 'hidden'
//							});
//						} else if (vals === '1') {
//							$('#keywordNeedImprovement').css({
//								'visibility' : 'hidden'
//							});
//
//						} else if (vals === '2') {
//
//							$('#keywordNeedImprovement').css({
//								'visibility' : 'visible'
//							});
//
//						}

					});

					/* end */

					/* here is code for video accepet or need to improvement */

					$('#videoAcceptOrNeedToImprovemenetByDomain')
							.click(
									function() {

										var categoryid = $("#categoryId").val();
										var topicid = $("#topicId").val();
										var lanId = $("#lanId").val();

										var vals = $("#VideoAcceptDomain")
												.val();

										if (vals == '0') {
											alert("Select Accept Or Need To Improvement");

										} else if (vals == '1') {

											$
													.ajax({

														type : "GET",
														url : "/acceptVideoByDomain",
														data : {
															"categorname" : categoryid,
															"topicid" : topicid,
															"lanId" : lanId
														},
														contentType : "application/json",
														success : function(
																result) {
															showStatus(SUCCESS, result);
//															$("#statusVideoByDomain").prop('disabled',false);
//															$('#statusVideoByDomain').html(result);

														},

														error : function(err) {
															console.log("not working. ERROR: "+ JSON.stringify(err));
															result = "Error";
															showStatus(ERROR, result);
														}
													});

										} else if (vals == '2') {

											$
													.ajax({

														type : "GET",
														url : "/needToImprovemenetByDomain",
														data : {
															"categorname" : categoryid,
															"topicid" : topicid,
															"lanId" : lanId
														},
														contentType : "application/json",
														success : function(
																result) {
//															$("#statusVideoByDomain").prop('disabled',false);
//															$('#statusVideoByDomain').html(result);
															showStatus(SUCCESS, result);

														},

														error : function(err) {
															console.log("not working. ERROR: "+ JSON.stringify(err));
															result = "Error";
															showStatus(ERROR, result);
														}

													});

										}

									});

					// Here is code for Domain review Accept or Need To
					// Improvement

					$('#scriptAcceptOrNeedToImprovemenetDomain')
							.click(
									function() {

										var categoryid = $("#categoryId").val();
										var topicid = $("#topicId").val();
										var lanId = $("#lanId").val();

										var vals = $("#scriptAcceptDomain")
												.val();

										if (vals == '0') {
											alert("Select Accept Or Need To Improvement");

										} else if (vals == '1') {

											$
													.ajax({

														type : "GET",
														url : "/commentOnScript",
														data : {
															"categorname" : categoryid,
															"topicid" : topicid,
															"lanId" : lanId
														},
														contentType : "application/json",
														success : function(
																result) {
//															$("#saveCommentScript").prop('disabled',false);
//															$('#saveCommentScript').html(result);
															showStatus(SUCCESS,result);
														},

														error : function(err) {
															console.log("not working. ERROR: "+ JSON.stringify(err));
															result = "Error";
															showStatus(ERROR,result);
														}
													});

										} else if (vals == "2") {

											var msgScript = $(
													"#msgScriptDomain").val();
											$.ajax({
												type : "GET",
												url : "/needToImpScriptByDomain",
												data : {
													"categorname" : categoryid,
													"topicid" : topicid,
													"lanId" : lanId,
													"msgScript" : msgScript
												},
												contentType : "application/json",
												success : function(result) {

													$("#saveCommentScript").prop('disabled',false);
													$('#saveCommentScript').html(result);
													showStatus(SUCCESS,result);
												},

												error : function(err) {
													console.log("not working. ERROR: "+JSON.stringify(err));
													result = "Error";
													showStatus(ERROR,result);
												}

											});

										}

									});

					/*
					 * Here is code for comment on componenet script Quality
					 * accept or need To Improvement
					 */

					$('#scriptAcceptOrNeedToImprovemenet')
							.click(
									function() {

										var categoryid = $("#categoryId").val();
										var topicid = $("#topicId").val();
										var lanId = $("#lanId").val();

										var vals = $("#scriptAccept").val();

										if (vals == '0') {
											alert("Select Accept Or Need To Improvement");

										} else if (vals == '1') {

											$
													.ajax({

														type : "GET",
														url : "/commentOnScriptByQuality",
														data : {
															"categorname" : categoryid,
															"topicid" : topicid,
															"lanId" : lanId
														},
														contentType : "application/json",
														success : function(
																result) {
//															$("#saveCommentScript").prop('disabled',false);
//															$('#saveCommentScript').html(result);
															showStatus(SUCCESS,result);

														},

														error : function(err) {
															console.log("not working. ERROR: "+ JSON.stringify(err));
															result = "Error";
															showStatus(ERROR,result);
														}

													});

										} else if (vals == "2") {

											var msgScript = $(
													"#msgScriptQuality").val();

											$
													.ajax({

														type : "GET",
														url : "/needToImpScriptByQuality",
														data : {
															"categorname" : categoryid,
															"topicid" : topicid,
															"lanId" : lanId,
															"msgScript" : msgScript
														},
														contentType : "application/json",
														success : function(
																result) {
//															$("#saveCommentScript").prop('disabled',false);
//															$('#saveCommentScript').html(result);
															showStatus(SUCCESS,result);

														},

														error : function(err) {
															console.log("not working. ERROR: "+JSON.stringify(err));
															result = "Error";
															showStatus(ERROR,result);
														}

													});

										}

									});

					// Here is code for Quality outline selection

					$('#OutlineAccepOrNeedToImprovementQuality').click(
							function() {

								var vals = $("#outlineQualitAceept").val();

								if (vals === '0') {
									$('#msgQualitytOutline').css({
										'visibility' : 'hidden'
									});

								}

								else if (vals === '1') {
									$('#msgQualitytOutline').css({
										'visibility' : 'hidden'
									});

								} else if (vals === '2') {

									$('#msgQualitytOutline').css({
										'visibility' : 'visible'
									});

								}

							});

					// here is code for Quality Outline Code for submition

					$('#submitQualityOutlineStatus')
							.click(
									function() {

										var categoryid = $("#categoryId").val();
										var topicid = $("#topicId").val();
										var lanId = $("#lanId").val();

										var vals = $("#outlineQualitAceept")
												.val();

										if (vals == '0') {
											alert("Accept Or Need To Improvement");

										} else if (vals == '1') {

											$
													.ajax({

														type : "GET",
														url : "/acceptOutlineByQuality",
														data : {
															"categorname" : categoryid,
															"topicid" : topicid,
															"lanId" : lanId
														},
														contentType : "application/json",
														success : function(
																result) {
															showStatus(SUCCESS,result);
//															$(
//																	"#commentOutlineByQuality")
//																	.prop(
//																			'disabled',
//																			false);
//															$(
//																	'#commentOutlineByQuality')
//																	.html(
//																			result);

														},

														error : function(err) {
															console
																	.log("not working. ERROR: "
																			+ JSON
																					.stringify(err));
															result ="Error occured";
															showStatus(ERROR,result);
														}

													});

										} else if (vals == '2') {

											var msg = $("#msgQualitytOutline")
													.val();

											$
													.ajax({

														type : "GET",
														url : "/needToImprovementOutLineByQuality",
														data : {
															"categorname" : categoryid,
															"topicid" : topicid,
															"lanId" : lanId,
															"msg" : msg
														},
														contentType : "application/json",
														success : function(
																result) {

//															$(
//																	"#commentOutlineByQuality")
//																	.prop(
//																			'disabled',
//																			false);
//															$(
//																	'#commentOutlineByQuality')
//																	.html(
//																			result);
															showStatus(SUCCESS,result);

														},

														error : function(err) {
															console
																	.log("not working. ERROR: "
																			+ JSON
																					.stringify(err));
															result ="Error occured";
															showStatus(ERROR,result);
														}

													});

										}

									});

					// Here is code for slide View into Quality

					$('#slideModaleView')
							.click(
									function() {

										var categoryid = $("#categoryId").val();
										var topicid = $("#topicId").val();
										var lanId = $("#lanId").val();
										$
												.ajax({

													type : "GET",
													url : "/slidePdfQuality",
													data : {
														"categorname" : categoryid,
														"topicid" : topicid,
														"lanId" : lanId
													},
													contentType : "application/json",
													success : function(result) {
														var res = result;

														source = document
																.getElementById('SlidePdfQuality');
														source.setAttribute(
																'href', res);

													},

													error : function(err) {
														console
																.log("not working. ERROR: "
																		+ JSON
																				.stringify(err));
													}

												});

									});

					// Slide Accept Or Need To Improvement
//					$('#slideAcceptOrNeedImp').click(function() {
					$('#slideAcceptByQuality').change(function() {

						var vals = $("#slideAcceptByQuality").val();
						
						 if (vals === '2') {
							$('#slideNeedToImp').show();
						}else{
							$('#slideNeedToImp').hide();
						}

//						if (vals === '0') {
//							$('#slideNeedToImp').css({
//								'visibility' : 'hidden'
//							});
//						} else if (vals === '1') {
//
//							$('#slideNeedToImp').css({
//								'visibility' : 'hidden'
//							});
//
//						} else if (vals === '2') {
//
//							$('#slideNeedToImp').css({
//								'visibility' : 'visible'
//							});
//
//						}

					});

					// Here is code for save comment into slide

					$('#slideAcceptOrNeedToImprovemenetByQuality')
							.click(
									function() {

										var categoryid = $("#categoryId").val();
										var topicid = $("#topicId").val();
										var lanId = $("#lanId").val();
										var vals = $("#slideAcceptByQuality")
												.val();

										if (vals == '0') {

											alert("Select Accept Or Need To Improvement");

											// here is code for Script // here
											// is code for Script
											// css({'visibility':'hidden'});

										} else if (vals == '1') {

											$
													.ajax({

														type : "GET",
														url : "/acceptSlideByQuality",
														data : {
															"categorname" : categoryid,
															"topicid" : topicid,
															"lanId" : lanId
														},
														contentType : "application/json",
														success : function(
																result) {

//															alert("result is"+ result);
//															$("#statusSlideByQuality").prop('disabled',false);
//															$('#statusSlideByQuality').html(result);
															showStatus(SUCCESS,result);

														},

														error : function(err) {
															console.log("not working. ERROR: "+ JSON.stringify(err));
															result = "Error";
															showStatus(ERROR,result);
														}

													});

										} else if (vals == '2') {

											$('#slideNeedToImp').css({
												'visibility' : 'visible'
											});

											var msg = $("#slideCommentMsg")
													.val();

											$
													.ajax({

														type : "GET",
														url : "/needToImprovementSlideByQuality",
														data : {
															"categorname" : categoryid,
															"topicid" : topicid,
															"lanId" : lanId,
															'msg' : msg
														},
														contentType : "application/json",
														success : function(
																result) {
//															$("#statusSlideByQuality").prop('disabled',false);
//															$('#statusSlideByQuality').html(result);
															showStatus(SUCCESS,result);

														},

														error : function(err) {
															console.log("not working. ERROR: "+ JSON.stringify(err));
															result = "Error";
															showStatus(ERROR,result);
														}

													});

										}

									});

					// here is code for Script for Quality Review
					$('#scriptStatusAccept').click(function() {

						var vals = $("#scriptAccept").val();
						if (vals === '0') {
							$('#msgScriptQuality').css({
								'visibility' : 'hidden'
							});
						} else if (vals === '1') {

							$('#msgScriptQuality').css({
								'visibility' : 'hidden'
							});

						} else if (vals === '2') {

							$('#msgScriptQuality').css({
								'visibility' : 'visible'
							});

						}

					});

					// Here is code for Script for Domain review

//					$('#scriptStatusAcceptDomain').click(function() {
					$('#scriptStatusAcceptDomain').change(function() {

						var vals = $("#scriptAcceptDomain").val();
						
						if (vals === '2'){
							$('#scriptNeedImprovement').show();
						}else{
							$('#scriptNeedImprovement').hide();
						}

//						if (vals === '0') {
//							$('#msgScriptDomain').css({
//								'visibility' : 'hidden'
//							});
//						} else if (vals === '1') {
//
//							$('#msgScriptDomain').css({
//								'visibility' : 'hidden'
//							});
//
//						} else if (vals === '2') {
//
//							$('#msgScriptDomain').css({
//								'visibility' : 'visible'
//							});
//
//						}

					});

					// Here is code for Accept Or Need To Improvement

					// Here is code for keyword Quality Review

					
//					$('#keywordAccepOrNeedToImprovementQuality').click(
					$('#keywordQualitAceept').change(
							function() {
								console.log('changed');
								var vals = $("#keywordQualitAceept").val();
								if (vals === '2'){
									$('#NeedImprovementKeyword').show();
								}
//								if (vals === '0') {
//
//									$('#msgkeywordQuality').css({
//										'visibility' : 'hidden'
//									});
//
//								} else if (vals === '1') {
//
//									$('#msgkeywordQuality').css({
//										'visibility' : 'hidden'
//									});
//
//								} else if (vals === '2') {
//
//									$('#msgkeywordQuality').css({
//										'visibility' : 'visible'
//									});
//
//								}

							});
					$('#graphicsQuality').change(
							function() {
								console.log('changed');
								var vals = $("#graphicsQuality").val();
								if (vals === '2'){
									$('#graphicsNeedImprovementByQuality').show();
								}
							});

					// here is code for Video review into Quality

//					$('#VideoAccepOrNeedToImprovementQuality').click(
					$('#videoQualitAceept').change(
							function() {

								var vals = $("#videoQualitAceept").val();

								if (vals === '2') {
									$('#NeedImprovement').show();
								}else{
									$('#NeedImprovement').hide();
								}
//								if (vals === '0') {
//
//									$('#msgVideoQuality').css({
//										'visibility' : 'hidden'
//									});
//
//								} else if (vals === '1') {
//
//									$('#msgVideoQuality').css({
//										'visibility' : 'hidden'
//									});
//
//								} else if (vals === '2') {
//
//									$('#msgVideoQuality').css({
//										'visibility' : 'visible'
//									});
//
//								}

							});

					// Here is code for Domain review -Slide

//					$('#SlideStatusAccept').click(function() {
					$('#SlideAcceptDomain').change(function() {

						var vals = $("#SlideAcceptDomain").val();

						if (vals === '2') {
							$('#slideNeedImprovement').show();
						}else{
							$('#slideNeedImprovement').hide();
						}
//						if (vals === '0') {
//
//							$('#slideNeedImprovement').css({
//								'visibility' : 'hidden'
//							});
//
//						} else if (vals === '1') {
//
//							$('#slideNeedImprovement').css({
//								'visibility' : 'hidden'
//							});
//
//						} else if (vals === '2') {
//
//							$('#slideNeedImprovement').css({
//								'visibility' : 'visible'
//							});
//
//						}

					});
					$('#graphicsDomain').change(function() {

						var vals = $("#graphicsDomain").val();

						if (vals === '2') {
							$('#graphicsNeedImprovement').show();
						}else{
							$('#graphicsNeedImprovement').hide();
						}

					});

					$('#slideAcceptOrNeedToImprovemenetByDomain').click(
									function() {
										var categoryid = $("#categoryId").val();
										var topicid = $("#topicId").val();
										var lanId = $("#lanId").val();

										var vals = $("#SlideAcceptDomain")
												.val();

										if (vals == '0') {

											alert("Select Accept Or Need To Improvement");

											// here is code for Script // here
											// is code for Script
											// css({'visibility':'hidden'});

										} else if (vals == '1') {

											$
													.ajax({

														type : "GET",
														url : "/acceptSlideByDomain",
														data : {
															"categorname" : categoryid,
															"topicid" : topicid,
															"lanId" : lanId
														},
														contentType : "application/json",
														success : function(result) {
//															$("#statusSlideByDomain").prop('disabled',false);
//															$('#statusSlideByDomain').html(result);
															showStatus(SUCCESS, result);

														},

														error : function(err) {
															console.log("not working. ERROR: "+ JSON.stringify(err));
															result = "Error";
															showStatus(ERROR, result);
														}

													});

										} else if (vals == '2') {

											var msg = $("#slideCommentMsg").val();
											$.ajax({
												type : "GET",
												url : "/needToImpSlideByDomain",
												data : {
													"categorname" : categoryid,
													"topicid" : topicid,
													"lanId" : lanId,
													'msg' : msg
												},
												contentType : "application/json",
												success : function(
														result) {

//													$("#statusSlideByDomain").prop('disabled',false);
//													$('#statusKeywordByQuality').html(result);
													showStatus(SUCCESS, result);
												},

												error : function(err) {
													console.log("not working. ERROR: "+ JSON.stringify(err));
													showStatus(ERROR, result);
												}

											});

										}

									});

					
					$('#graphicsAcceptOrNeedToImprovemenetByDomain').click(
							function() {
								console.log('here');
								var categoryid = $("#categoryId").val();
								var topicid = $("#topicId").val();
								var lanId = $("#lanId").val();

								var vals = $("#graphicsDomain")
										.val();

								if (vals == '0') {

									alert("Select Accept Or Need To Improvement");

									// here is code for Script // here
									// is code for Script
									// css({'visibility':'hidden'});

								} else if (vals == '1') {

									$
											.ajax({

												type : "GET",
												url : "/acceptGraphicsByDomain",
												data : {
													"categorname" : categoryid,
													"topicid" : topicid,
													"lanId" : lanId
												},
												contentType : "application/json",
												success : function(result) {
//													$("#statusSlideByDomain").prop('disabled',false);
//													$('#statusSlideByDomain').html(result);
													showStatus(SUCCESS, result);

												},

												error : function(err) {
													console.log("not working. ERROR: "+ JSON.stringify(err));
													result = "Error";
													showStatus(ERROR, result);
												}

											});

								} else if (vals == '2') {

									var msg = $("#graphicsCommentMsg").val();
									$.ajax({
										type : "GET",
										url : "/needToImpGraphicsByDomain",
										data : {
											"categorname" : categoryid,
											"topicid" : topicid,
											"lanId" : lanId,
											'msg' : msg
										},
										contentType : "application/json",
										success : function(
												result) {

//											$("#statusSlideByDomain").prop('disabled',false);
//											$('#statusKeywordByQuality').html(result);
											showStatus(SUCCESS, result);
										},

										error : function(err) {
											console.log("not working. ERROR: "+ JSON.stringify(err));
											result = "Error";
											showStatus(ERROR, result);
										}

									});

								}

							});

					// End Slide for DOmain review

					// here is code for Accept Or Need To Improvement Script

					$('#KeyWordAcceptOrNeedToImprovemenetByQuality')
							.click(
									function() {
//										alert('clicked');
										var categoryid = $("#categoryId").val();
										var topicid = $("#topicId").val();
										var lanId = $("#lanId").val();

										var vals = $("#keywordQualitAceept")
												.val();

										if (vals == '0') {

											alert("Select Accept Or Need To Improvement");

											// here is code for Script // here
											// is code for Script
											// css({'visibility':'hidden'});

										} else if (vals == '1') {

											$
													.ajax({

														type : "GET",
														url : "/acceptKeywordByQuality",
														data : {
															"categorname" : categoryid,
															"topicid" : topicid,
															"lanId" : lanId
														},
														contentType : "application/json",
														success : function(
																result) {
															showStatus(SUCCESS,result);
//															$("#statusKeywordByQuality").prop('disabled',false);
//															$('#statusKeywordByQuality').html(result);

														},

														error : function(err) {
															console.log("not working. ERROR: "+ JSON.stringify(err));
															result = "Error";
															showStatus(ERROR,result);
														}

													});

										} else if (vals == '2') {
											$('#NeedImprovementKeyword').prop('readonly', true);
											var msg = $(
													"#keywordViewInDomainKeyword")
													.val();

											$
													.ajax({

														type : "GET",
														url : "/needToImprovementKeywordByQuality",
														data : {
															"categorname" : categoryid,
															"topicid" : topicid,
															"lanId" : lanId,
															'msg' : msg
														},
														contentType : "application/json",
														success : function(
																result) {

//															$("#statusKeywordByQuality").prop('disabled',false);
//															$('#statusKeywordByQuality').html(result);
															showStatus(SUCCESS,result);
														},

														error : function(err) {
															console.log("not working. ERROR: "+ JSON.stringify(err));
															result = "Error";
															showStatus(ERROR,result);
														}

													});

										}

									});

				//
					

					$('#graphicsAcceptOrNeedToImprovemenetByQuality')
							.click(
									function() {
//										alert('clicked');
										var categoryid = $("#categoryId").val();
										var topicid = $("#topicId").val();
										var lanId = $("#lanId").val();

										var vals = $("#graphicsQuality")
												.val();

										if (vals == '0') {

											alert("Select Accept Or Need To Improvement");

											// here is code for Script // here
											// is code for Script
											// css({'visibility':'hidden'});

										} else if (vals == '1') {

											$
													.ajax({

														type : "GET",
														url : "/acceptGraphicsByQuality",
														data : {
															"categorname" : categoryid,
															"topicid" : topicid,
															"lanId" : lanId
														},
														contentType : "application/json",
														success : function(
																result) {
															showStatus(SUCCESS,result);
//															$("#statusKeywordByQuality").prop('disabled',false);
//															$('#statusKeywordByQuality').html(result);

														},

														error : function(err) {
															console.log("not working. ERROR: "+ JSON.stringify(err));
															result = "Error";
															showStatus(ERROR,result);
														}

													});

										} else if (vals == '2') {
											$('#graphicsCommentMsg').prop('readonly', true);
											var msg = $(
													"#graphicsCommentMsg")
													.val();

											$
													.ajax({

														type : "GET",
														url : "/needToImprovementGraphicsByQuality",
														data : {
															"categorname" : categoryid,
															"topicid" : topicid,
															"lanId" : lanId,
															'msg' : msg
														},
														contentType : "application/json",
														success : function(
																result) {

//															$("#statusKeywordByQuality").prop('disabled',false);
//															$('#statusKeywordByQuality').html(result);
															showStatus(SUCCESS,result);
														},

														error : function(err) {
															console.log("not working. ERROR: "+ JSON.stringify(err));
															result = "Error";
															showStatus(ERROR,result);
														}

													});

										}

									});
			
					
					
					/*Here is code for Contributor PreRequistic component  display topic */
				
								$('#catAllID').change(function(){
										
										var selectedCategoryId=$(this).find(":selected").val();
									    var lanId =$("#lanId").val();
										$.ajax({
											  	type: "GET",
									       		 url: "/loadTopicByPreRequistic",
									       		 data: { "id": selectedCategoryId, "lanId":lanId},
									       		 contentType: "application/json",
									       		 success: function (result)
									       		 {
									       			 
									        		var html = '';
										            var len = result.length;
										            html += '<option value="0"></option>';
										            for (var i = 0; i < len; i++) {
										             html += '<option value="' + result[i] + '">'
										               + result[i]
										               + '</option>';
										            }
										            html += '</option>';
										            
										            $("#inputTopicPre").prop('disabled',false);
										            $('#inputTopicPre').html(html);
								
													},
													
													error : function(err){
													console.log("not working. ERROR: "+JSON.stringify(err));
												}
												
											});
									
										});

		
					// Here is code for upload preRequistic link path
								
					$('#preRequistic').click(function()
							{
					
									var selectedCategoryId=$(this).find(":selected").val();
									var lanId =$("#lanId").val();
									var inputTopicPre =$("#inputTopicPre").val();
									
									
									alert(inputTopicPre);
									
										$.ajax({
										  	type: "GET",
								       		 url: "/loadTopicByPreRequistic",
								       		 data: { "id": selectedCategoryId, "lanId":lanId},
								       		 contentType: "application/json",
								       		 success: function (result)
								       		 {
								       			 
								       			 alert("save information");
								       			 
								        		var html = '';
									            var len = result.length;
									            html += '<option value="0">Select Topic</option>';
									            for (var i = 0; i < len; i++) {
									             html += '<option value="' + result[i] + '">'
									               + result[i]
									               + '</option>';
									            }
									            html += '</option>';
									            
									            $("#inputTopicPre").prop('disabled',false);
									            $('#inputTopicPre').html(html);
							
												},
												
												error : function(err){
												console.log("not working. ERROR: "+JSON.stringify(err));
											}
											
										});
								
									});

					
					
					/*Here is code for Contributor PreRequistic component  display topic */
				
								$('#catAllID').change(function(){
										
										var selectedCategoryId=$(this).find(":selected").val();
									    var lanId =$("#lanId").val();
										$.ajax({
											  	type: "GET",
									       		 url: "/loadTopicByPreRequistic",
									       		 data: { "id": selectedCategoryId, "lanId":lanId},
									       		 contentType: "application/json",
									       		 success: function (result)
									       		 {
									       			 
									        		var html = '';
										            var len = result.length;
										            html += '<option value="0"></option>';
										            for (var i = 0; i < len; i++) {
										             html += '<option value="' + result[i] + '">'
										               + result[i]
										               + '</option>';
										            }
										            html += '</option>';
										            
										            $("#inputTopicPre").prop('disabled',false);
										            $('#inputTopicPre').html(html);
								
													},
													
													error : function(err){
													console.log("not working. ERROR: "+JSON.stringify(err));
												}
												
											});
									
										});

		
					
					
					// Here is code for upload preRequistic link path
								
					$('#preRequistic').click(function()
							{
					
									var selectedCategoryId=$(this).find(":selected").val();
									var lanId =$("#lanId").val();
									var inputTopicPre =$("#inputTopicPre").val();
									
									
									alert(inputTopicPre);
									
										$.ajax({
										  	type: "GET",
								       		 url: "/loadTopicByPreRequistic",
								       		 data: { "id": selectedCategoryId, "lanId":lanId},
								       		 contentType: "application/json",
								       		 success: function (result)
								       		 {
								       			 
								       			 alert("save information");
								       			 
								        		var html = '';
									            var len = result.length;
									            html += '<option value="0">Select Topic</option>';
									            for (var i = 0; i < len; i++) {
									             html += '<option value="' + result[i] + '">'
									               + result[i]
									               + '</option>';
									            }
									            html += '</option>';
									            
									            $("#inputTopicPre").prop('disabled',false);
									            $('#inputTopicPre').html(html);
							
												},
												
												error : function(err){
												console.log("not working. ERROR: "+JSON.stringify(err));
											}
											
										});
								
									});
		
					
					$('#VideoAcceptOrNeedToImprovemenetByQuality')
							.click(
									function() {
										// chage

										var categoryid = $("#categoryId").val();
										var topicid = $("#topicId").val();
										var lanId = $("#lanId").val();

										var vals = $("#videoQualitAceept")
												.val();

										if (vals == '0') {

											alert("Select Accept Or Need To Improvement");

											// here is code for Script // here
											// is code for Script
											// css({'visibility':'hidden'});

										} else if (vals == '1') {

											$
													.ajax({

														type : "GET",
														url : "/acceptVideoByQuality",
														data : {
															"categorname" : categoryid,
															"topicid" : topicid,
															"lanId" : lanId
														},
														contentType : "application/json",
														success : function(
																result) {

															$(
																	"#statusQualityByQuality")
																	.prop(
																			'disabled',
																			false);
															$(
																	'#statusQualityByQuality')
																	.html(
																			result);
															showStatus(SUCCESS,result);

														},

														error : function(err) {
															console
																	.log("not working. ERROR: "
																			+ JSON
																					.stringify(err));
															result = "Error";
															showStatus(ERROR,result);
														}

													});

										} else if (vals == '2') {

											var msg = $("#msgkeywordQuality")
													.val();

											$
													.ajax({

														type : "GET",
														url : "/needToImprovementQualityByQuality",
														data : {
															"categorname" : categoryid,
															"topicid" : topicid,
															"lanId" : lanId,
															'msg' : msg
														},
														contentType : "application/json",
														success : function(
																result) {

															$(
																	"#statusQualityByQuality")
																	.prop(
																			'disabled',
																			false);
															$(
																	'#statusQualityByQuality')
																	.html(
																			result);
															
															showStatus(SUCCESS,result);

														},

														error : function(err) {
															console
																	.log("not working. ERROR: "
																			+ JSON
																					.stringify(err));
															result = "Error";
															showStatus(ERROR,result);
														}

													});

										}

									});
					
					$(".c-modal-close").click(function() {
						console.log('this');
						   $(".modal").removeClass("is-active");
						});
					
					
					
					$(".comment-contri").click(function() {
						console.log('this');
						component = this.id;
						var elem_id = '#'+component+'_comment'
						var categoryid = $("#categoryId").val();
						var topicid = $("#topicId").val();
						var lanId = $("#lanId").val();
						var msg = $(elem_id)
						.val();
				$.ajax({
							type : "GET",
							url : "/commentByContributor",
							data : {
								"categorname" : categoryid,
								"topicid" : topicid,
								"component":component,
								"lanId" : lanId,
								'msg' : msg
							},
							contentType : "application/json",
							success : function(
									result) {
//								alert('msg saved!');
								// $("#statusOutlineByDomain").prop('disabled',false);
								// $('#statusOutlineByDomain').html(result);
							},

							error : function(err) {
								console.log("not working. ERROR: "+ JSON.stringify(err));
								
							}
						});
						 
						});
					
					$("#show_all_consultants").click(function() {
						console.log('this');
						$.ajax({
				   		  	 type: "GET",
				       		 url: "/displayConsultants",
				       		 contentType: "application/json",
				       		 success: function (result){
				       		 console.log(result);
				       		 $('.cons_record').show();
				       		var id = result[0].id;
				       		var name = result[0].nameConsaltant;
				       		var desc = result[0].descriptionConsaltant;
				       		var img = result[0].uploadConsaltantImage;
				       		var editLink = 'productconsalantant/edit/' + id;
				       		var elink = '<a href="'+editLink+'">Edit</a>';
				       		var deleteLink = '/consalantant/delete/' + id;
				       		var dlink = '<a onclick="submitForm()" href="'+deleteLink+'">Delete</a>';
				       		
				       		var markup = "<tr><td>" + id + "</td><td>" + name + "</td><td>"+desc+"</td><td>"+"image"+"</td><td>"+elink+"</td><td>"+dlink+"</td></tr>";
				       		
				       		console.log(elink);
				       		console.log(dlink);
				       		console.log(markup);
				            $("table tbody").append(markup);
				       		 
								},
								
									error : function(err){
								console.log("not working. ERROR: "+JSON.stringify(err));
							}
						});
						});
					
					
					$('#categorySelect').on(
							'change',
							function() {
								var category = $(this).val();

								$.ajax({
									type : "GET",
									url : "/listTopicByCategory",
									data : {
										"category" : category
									},
									contentType : "application/json",
									success : function(result) {

										var html = '';
										var len = result.length;

										for (var i = 0; i < len; i++) {
											html += '<option value="'
													+ result[i] + '">'
													+ result[i] + '</option>';
										}
										html += '</option>';

										$("#topicSelect")
												.prop('disabled', false);
										$('#inputTopic').html(html);

									},
									error : function(err) {
										console.log("not working. ERROR: "
												+ JSON.stringify(err));
									}
								});

							});
					
					$(".logoToUpload").on('change', function() {
				        
				        var fileSize = this.files[0].size;
				        if(fileSize > 200000){
				        	alert("File size should be less than 5kB");
				        	this.value="";
				        	return false;
				        }
				});

				});

/* here is code for download question */

// $('#inputLanguage1').change(function(){
// $.ajax({
// type: "GET",
// url: "/loadLanguageByUser",
// data: { "id": userContributor},
// contentType: "application/json",
// success: function (result){
//		
//						       			
// var html = '';
// var len = result.length;
// html += '<option value="0">Select Language</option>';
// for (var i = 0; i < len; i++) {
// html += '<option value="' + result[i] + '">'
// + result[i]
// + '</option>';
// }
// html += '</option>';
//							            
// $("#lanId").prop('disabled',false);
// $('#lanId').html(html);
//							            
//										},
//										
//										error : function(err){
//											console.log("not working. ERROR: "+JSON.stringify(err));
//										}
//									});
//								
//								
//							
//				});