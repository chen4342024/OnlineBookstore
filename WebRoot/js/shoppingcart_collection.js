var shoppingCart = {
	addBookToShoppingCart:function(element){
		$.ajax({
			type: "POST",
				url: "addBookToCart.do?book.book_id="+element.name,
				dataType: 'text',
				async: false,
				error:function(data){	
						alert("error");			
				},
				success: function(data){
							
					if((data=="success")){									
						alert("加入购物车成功");
					}else{
						alert("input");
					}															
			}		
		});
	}
}
var customerCollect = {
	addToCollection : function (element){
		$.ajax({
			type: "POST",
				url: "addToCollection.do?book.book_id="+element.name,
				dataType: 'text',
				async: false,
				error:function(data){	
						alert("error");			
				},
				success: function(data){
					if((data=="success")){									
						alert("已添加到个人收藏");
					}else if(data=="repeat"){
						alert("收藏夹内已存在");
					}else{
						alert("收藏出错");
					}														
			}		
		});
	}	
}

