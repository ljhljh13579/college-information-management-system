	function is_submit(value) {
		var form1 = document.getElementById("form1");//$("form1");
		if (value == 1) {
			//var id = $("#id").val();
			form1.action = "/Book/SearchBook?type=allbook";
			//form1.attr("action", form1.action);
			form1.submit();
		}
		if (value == 2) {
			form1.action = "/Book/jsp/SearchByID.jsp" ;
			form1.submit();

		}
		if (value == 3) {
		    form1.action = "/Book/jsp/SearchByName.jsp" ;
			//var minprice = $("#minprice").val();
			//var maxprice = $("#maxprice").val();
			//form1.action = "/Test/querrybyprice?minprice=" + minprice
			//		+ "&maxprice=" + maxprice;
			//$("#form1").attr("action", form1.action);
			form1.submit();
		}
		if (value == 4) {
			//var ison = $(":radio[name='ison']:checked").val()
			//form1.action = "/Test/querrybyison?ison=" + ison;
			//$("#form1").attr("action", form1.action);
			form1.action = "/Book/jsp/AddBook.jsp" ;
			form1.submit();
		}
	}