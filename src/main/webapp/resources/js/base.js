function ajaxPost(url, params, callback) {
	var result = null;
    var headers={};
    headers['CSRFToken']=$("#csrftoken").val();
	$.ajax({
		type : 'post',
		async : false,
		url : url,
		data : params,
		dataType : 'json',
		headers:headers,
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		success : function(data, status) {
			result = data;
			if(data&&data.code&&data.code=='101'){
				modals.error("操作失败，请刷新重试，具体错误："+data.message);
				return false;
			}
			if (callback) { 
				callback.call(this, data, status);
			}
		},
		error : function(err, err1, err2) {
		    if(err && err.readyState && err.readyState == '4'){
                var responseBody = err.responseText;
                if(responseBody){ 
                	 try{
	                	 responseBody = "{'retData':"+responseBody;
	                     var resJson = eval('(' + responseBody + ')');
	                     $("#csrftoken").val(resJson.csrf.CSRFToken);
	                     this.success(resJson.retData, 200);
                	 }catch(e){

                	 }
                }
                return ;
            } 		    
			modals.error({
				text : JSON.stringify(err) + '<br/>err1:' + JSON.stringify(err1) + '<br/>err2:' + JSON.stringify(err2),
				large : true
			});
		}
	});

	return result;
}


function ajaxPost2(url, params, callback, config, config2) {
	var layer_index = layer.load(2, $.extend({shade:0.5},config));
    var headers={};
    headers['CSRFToken']=$("#csrftoken").val();
    
	$.ajax($.extend({
		type : 'post',
		async : true,
		url : url,
		data : params,
		dataType : 'json',
		headers:headers,
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		success : function(data, status) {
			layer.close(layer_index);
			if (callback) { 
				callback.call(this, data, status);
			}else {
				modals.error("提交失败, 请稍后再试!");
			}
		},
		error : function(err, err1, err2) {
			layer.close(layer_index);
			modals.error("提交失败, 请稍后再试!");
		}
	}, config2));
}
