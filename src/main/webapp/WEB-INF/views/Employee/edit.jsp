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
				<li><a href="/employee/index">Employee</a> <i
					class="icon-angle-right"></i></li>
				<li><a>Edit Employee</a></li>
			</ul>
			<div class="close-bread">
				<a href="#"><i class="icon-remove"></i></a>
			</div>
		</div>
		<div class="row-fluid">
			<div class="span12">
				<div class="box box-bordered">
					<div class="box-title">
						<h3>
							<i class="icon-plus"></i> Edit Employee
						</h3>
					</div>
					<div class="box-content nopadding">
						<form action="/employee/edit" method="POST"
							class='form-validate form-horizontal form-column form-bordered'
							id="employee">
							<input type="hidden" name="employeeId" value="${employee.id}" />
							<div class="span6">
								<div
									class="control-group <c:if test="${firstNameHasError eq true}">error</c:if>">
									<label for="firstName" class="control-label">First Name</label>
									<div class="controls">
										<input type="text" name="firstName" id="firstName"
											value="${employee.firstName}" data-rule-required="true"
											data-rule-maxlength="20" /> <span class="help-block error">${firstNameError}</span>
									</div>
								</div>
								<div
									class="control-group <c:if test="${lastNameHasError eq true}">error</c:if>">
									<label for="lastName" class="control-label">Last Name</label>
									<div class="controls">
										<input type="text" name="lastName" id="lastName"
											value="${employee.lastName}" data-rule-required="true"
											data-rule-maxlength="30" /> <span class="help-block error">${lastNameError}</span>
									</div>
								</div>
								<div
									class="control-group <c:if test="${birthdayHasError eq true}">error</c:if>">
									<label for="birthday" class="control-label">Birthday</label>
									<div class="controls">
										<input type="text" name="birthday" id="birthday"
											value="<fmt:formatDate value="${employee.birthday}" pattern="MM/dd/yyyy"/>"
											class="datepick" data-rule-required="true" /> <span
											class="help-block error">${birthdayError}</span>
									</div>
								</div>
								<div
									class="control-group <c:if test="${phoneHasError eq true}">error</c:if>">
									<label for="phone" class="control-label">Phone</label>
									<div class="controls">
										<input type="text" name="phone" id="phone" class="mask_phone"
											value="${employee.phone}" data-rule-required="true" /> <span
											class="help-block error">${phoneError}</span>
									</div>
								</div>
								<div
									class="control-group <c:if test="${addressHasError eq true}">error</c:if>">
									<label for="address" class="control-label">Address</label>
									<div class="controls">
										<textarea style="resize: none" name="address"
											data-rule-required="true" data-rule-maxlength="150">${employee.address}</textarea>
										<span class="help-block error">${addressError}</span>
									</div>
								</div>
							</div>
							<div class="span6">
								<div
									class="control-group <c:if test="${emailHasError eq true}">error</c:if>">
									<label for="email" class="control-label">Email</label>
									<div class="email controls">
										<input type="text" id="email" name="email"
											value="${employee.account.email}"
											placeholder="someone@xample.com" data-rule-required="true"
											data-rule-email="true" /> <span class="help-block error">${emailError}</span>
									</div>
								</div>
								<div
									class="control-group <c:if test="${passwordHasError eq true}">error</c:if>">
									<label for="password" class="control-label">Password</label>
									<div class="controls">
										<input type="password" name="password"
											data-rule-required="true" id="password" /> <span
											class="help-block error">${passwordError}</span>
									</div>
								</div>
								<div
									class="control-group <c:if test="${cfpwHasError eq true}">error</c:if>">
									<label for="cfpw" class="control-label">Confirm It</label>
									<div class="controls">
										<input type="password" name="cfpw" id="cfpw"
											data-rule-equalTo="#password" /> <span
											class="help-block error">${cfpwError}</span>
									</div>
								</div>
								<div
									class="control-group <c:if test="${roleIdHasError eq true}">error</c:if>">
									<label for="roleId" class="control-label">User Role</label>
									<div class="controls">
										<select id="roleId" name="roleId" style="width: 160px;"
											data-rule-required="true">
											<option value="">--- Please choose ---</option>
											<c:forEach items="${roles}" var="role">
												<c:choose>
													<c:when test="${role.id eq employee.account.role.id }">
														<option value="${role.id}" selected="selected">${role.roleName}</option>
													</c:when>
													<c:otherwise>
														<option value="${role.id}">${role.roleName}</option>
													</c:otherwise>
												</c:choose>
											</c:forEach>
										</select> <span class="help-block error">${roleError}</span>
									</div>
								</div>
								<div
									class="control-group <c:if test="${insMoneyAcceptedPerYearHasError eq true}">error</c:if>">
									<label for="insMoneyAcceptedPerYear" class="control-label">Insurance
										Money Per Year</label>
									<div class="controls">
										<input type="text" name="insMoneyAcceptedPerYear"
											id="insMoneyAcceptedPerYear" data-rule-required="true"
											value="${employee.insMoneyAcceptedPerYear}"
											data-rule-number="true" /> <span class="help-block error">${insMoneyAcceptedPerYearError}</span>
									</div>
									<script type="text/javascript">
										$(function() {
											$('#insMoneyAcceptedPerYear')
													.number(true, 2);
										});
									</script>
								</div>
							</div>
							<div class="span12">
								<div class="form-actions">
									<input type="submit" class="btn btn-primary"
										value="Save Changes" /> <input type="reset" class="btn"
										value="Cancel" />
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
