<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:url id="localeEN" namespace="/" action="locale" >
   <s:param name="request_locale" >en</s:param>
</s:url>
<s:url id="localeES" namespace="/" action="locale" >
   <s:param name="request_locale" >es</s:param>
</s:url>
<s:url id="localeEU" namespace="/" action="locale" >
   <s:param name="request_locale" >eu</s:param>
</s:url>
<s:i18n name="resources">
<nav class="pushy pushy-left">
	<ul class="list-unstyled">
		<li><a href="index.jsp#home"><i class="fa fa-home" aria-hidden="true"></i> Home</a></li>
		<li><a href="flightinfo.jsp"><i class="fa fa-plane" aria-hidden="true"></i> <s:property value="getText('home.flightinfo')"/></a></li>
		<li><a href="timetable.jsp"><i class="fa fa-table" aria-hidden="true"></i> <s:property value="getText('home.timetable')"/></a></li>
		<li><a href="index.jsp#feat"><i class="fa fa-refresh" aria-hidden="true"></i> <s:property value="getText('home.facilities')"/></a></li>
		<li><a href="index.jsp#about"><i class="fa fa-info-circle" aria-hidden="true"></i> <s:property value="getText('home.aboutus')"/></a></li>
		<li><a href="index.jsp#news"><i class="fa fa-rss" aria-hidden="true"></i> <s:property value="getText('home.blogs')"/></a></li>
		<li><a href="index.jsp#history"><i class="fa fa-history" aria-hidden="true"></i> <s:property value="getText('home.history')"/></a></li>
		<li><a href="index.jsp#photos"><i class="fa fa-picture-o" aria-hidden="true"></i> <s:property value="getText('home.photos')"/></a></li>
		<li><a href="index.jsp#contact"><i class="fa fa-envelope" aria-hidden="true"></i> <s:property value="getText('home.contactus')"/></a></li>
		<li><a href="login.jsp"><i class="fa fa-user" aria-hidden="true"></i> Member Access</a></li>
		<li>
		<div style="text-align: center;">
		<s:a href="%{localeEN}" ><img src="images/en_flag.png" style="width: 40px; height: 27px; cursor: pointer;"></s:a>
		<s:a href="%{localeES}" ><img src="images/es_flag.png" style="width: 40px; height: 27px; cursor: pointer;"></s:a>
		<s:a href="%{localeEU}" ><img src="images/eu_flag.png" style="width: 40px; height: 27px; cursor: pointer;"></s:a>
		</div>
		</li>
	</ul>
		<p>
			<a href="http://jigsaw.w3.org/css-validator/check/referer"> <img
				style="border: 0; width: 88px; height: 31px"
				src="http://jigsaw.w3.org/css-validator/images/vcss-blue"
				alt="¡CSS Válido!" />
			</a>
		</p>
	</nav>
</s:i18n>