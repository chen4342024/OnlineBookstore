$(document).ready(function () {
	$(".delete").click(function(){
		var orderStratus=$(this).attr("name");
		var orderId=$(this).attr("id");
		if(confirm("真的要删除吗？？")){
			if(orderStratus!=0){
				alert("订单已提交，不能取消");
			}else{
				$.ajax({
					type: "POST",
					url: "deleteOrder.do?order.order_id="+orderId,
					dataType: 'text',
					error:function(data){
										
					},
					success: function(data){
						if((data=="success")){									
							alert("删除成功");
							location.href = "show_order_by_customer.do?page=1" ;
						}else if((data=="input")){
							alert("删除失败");
						}	
																				
					}
									
				});	
			}
		}																	
	});
	$(".confirmReceipt").click(function(){
		var orderStratus=$(this).attr("name");
		var orderId=$(this).attr("id");
		if(confirm("确定收货吗？请确保您已经收到货了才能点击确定")){
			if(orderStratus!=3){
				alert("系统出错，请刷新页面");
			}else{
				$.ajax({
					type: "POST",
					url: "confirmReceipt.do?order.order_id="+orderId,
					dataType: 'text',
					error:function(data){
										
					},
					success: function(data){
						if((data=="success")){									
							alert("已确认收货");
							location.href = "show_order_by_customer.do?page=1" ;
						}else if((data=="input")){
							alert("确认收货失败");
						}	
																				
					}
									
				});	
			}
		}																	
	});
	
	$(".comment").click(function(){
		var orderStratus=$(this).attr("name");
		var orderId=$(this).attr("id");		
		if(orderStratus!=4){
			alert("交易还没完成，不能取消");
		}else{
				
		}
		
	});
});