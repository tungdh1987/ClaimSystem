<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div id="main">
	<div class="container-fluid">
		<div class="page-header">
			<div class="pull-left">
				<h1>Employee</h1>
			</div>
			<div class="pull-right">
				<ul class="stats">
					<li class='blue'><i class="icon-calendar"></i>
						<div class="details">
							<span class="big">February 22, 2013</span> <span>Wednesday,
								13:56</span>
						</div></li>
				</ul>
			</div>
		</div>
		<div class="breadcrumbs">
			<ul>
				<li><a href="/home/index">Home</a> <i class="icon-angle-right"></i></li>
				<li><a>Employee</a></li>
			</ul>
			<div class="close-bread">
				<a href="#"><i class="icon-remove"></i></a>
			</div>
		</div>
		<div class="row-fluid">
			<div class="span12">
				<div class="box box-color box-bordered">
					<div class="box-title">
						<h3 style="margin-right: 10px;">
							<i class="icon-table"></i> Employees List
						</h3>
						<a href="/employee/create" class="btn"><i
							class="icon-plus-sign"></i> Add New</a>
						<form style="float: right; margin-left: 0;"
							action="/employee/search" method="GET" class="search-form">
							<div style="float: left; margin-top: -0.5px; margin-right: 5px;"
								class="input-medium">
								<select name="searchBy" class='valid chosen-select'>
									<option value="fullName"
										<c:if test='${searchBy eq "fullName"}'>selected</c:if>>Full
										Name</option>
									<option value="email"
										<c:if test='${searchBy eq "email"}'>selected</c:if>>Email</option>
									<option value="userRole"
										<c:if test='${searchBy eq "userRole"}'>selected</c:if>>User
										Role</option>
								</select>
							</div>
							<div style="margin: 0 5px 0 0; float: right;" class="search-pane">
								<input type="text" style="width: 290px; font-style: italic;"
									name="q" placeholder="Search employee in here...">
								<button type="submit">
									<i class="icon-search"></i>
								</button>
							</div>
						</form>
					</div>
					<div class="box-content nopadding">
						<c:choose>
							<c:when test="${not empty employees}">
								<table class="table table-hover table-nomargin table-bordered">
									<thead>
										<tr>
											<th style="width: 200px;">Full Name</th>
											<th style="width: 170px;">Birthday</th>
											<th style="width: 150px;">Phone</th>
											<th>Email</th>
											<th>User Role</th>
											<th style="width: 100px;"></th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${employees}" var="employee">
											<tr>
												<td><c:out
														value="${employee.firstName} ${employee.lastName}"></c:out>
												</td>
												<td><fmt:formatDate value="${employee.birthday}"
														pattern="MM/dd/yyyy" /></td>
												<td>${employee.phone}</td>
												<td>${employee.account.email}</td>
												<td>${employee.account.role.roleName}</td>
												<td style="text-align: center;"><a
													href="/employee/edit/${employee.id}" class="btn"
													rel="tooltip" title="Edit"><i class="icon-edit"></i></a> <a
													href="#" class="btn" rel="tooltip" title="Delete"><i
														class="icon-remove"></i></a></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</c:when>
							<c:otherwise>
								<c:if test='${action eq "search"}'>
									<div class="span12">
										<div class="control-group">
											<label for="noSearchResult" class="control-label"></label>
											<div style="margin-left: 20px;" class="controls">
												<h3>Search results for: "${param["q"]}"</h3>
												<br />
												<h5 style="font-weight: 300; line-height: 1.25;">-
													There were no employees found for your search.</h5>
											</div>
										</div>
									</div>
								</c:if>
							</c:otherwise>
						</c:choose>
						<c:if test="${page.totalPages gt 1}">
							<c:choose>
								<c:when test='${action eq "search"}'>
									<c:url var="firstUrl" value="${url}&page=1" />
									<c:url var="lastUrl" value="${url}&page=${page.totalPages}" />
									<c:url var="prevUrl" value="${url}&page=${currentIndex - 1}" />
									<c:url var="nextUrl" value="${url}&page=${currentIndex + 1}" />
								</c:when>
								<c:otherwise>
									<c:url var="firstUrl" value="${url}?page=1" />
									<c:url var="lastUrl" value="${url}?page=${page.totalPages}" />
									<c:url var="prevUrl" value="${url}?page=${currentIndex - 1}" />
									<c:url var="nextUrl" value="${url}?page=${currentIndex + 1}" />
								</c:otherwise>
							</c:choose>
							<div class="table-pagination">
								<c:choose>
									<c:when test="${currentIndex == 1}">
										<a class='disabled'><i class="icon-double-angle-left"></i></a>
										<a class='disabled'><i class="icon-angle-left"></i></a>
									</c:when>
									<c:otherwise>
										<a href="${firstUrl}"><i class="icon-double-angle-left"></i></a>
										<a href="${prevUrl}"><i class="icon-angle-left"></i></a>
									</c:otherwise>
								</c:choose>
								<span> <c:forEach var="i" begin="${beginIndex}"
										end="${endIndex}">
										<c:choose>
											<c:when test='${action eq "search"}'>
												<c:url var="pageUrl" value="${url}&page=${i}" />
											</c:when>
											<c:otherwise>
												<c:url var="pageUrl" value="${url}?page=${i}" />
											</c:otherwise>
										</c:choose>
										<c:choose>
											<c:when test="${i eq currentIndex}">
												<a class='active'>${i}</a>
											</c:when>
											<c:otherwise>
												<a href="${pageUrl}">${i}</a>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</span>
								<c:choose>
									<c:when test="${currentIndex == page.totalPages}">
										<a class='disabled'><i class="icon-angle-right"></i></a>
										<a class='disabled'><i class="icon-double-angle-right"></i></a>
									</c:when>
									<c:otherwise>
										<a href="${nextUrl}"><i class="icon-angle-right"></i></a>
										<a href="${lastUrl}"><i class="icon-double-angle-right"></i></a>
									</c:otherwise>
								</c:choose>
							</div>
						</c:if>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
