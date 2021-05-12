# javaWeb
<form th:action="@{/emp}" method="post">
						<div class="form-group">
							<label>LastName</label>
							<input type="text" class="form-control" name="lastName" placeholder="kuangshen">
						</div>
						<div class="form-group">
							<label>Email</label>
							<input type="email" class="form-control" name="email" placeholder="24736743@qq.com">
						</div>
						<div class="form-group">
							<label>Gender</label><br/>
							<div class="form-check form-check-inline">
								<input class="form-check-input" type="radio" name="gender"  value="1">
								<label class="form-check-label">男</label>
							</div>
							<div class="form-check form-check-inline">
								<input class="form-check-input" type="radio" name="gender"  value="0">
								<label class="form-check-label">女</label>
							</div>
						</div>
						<div class="form-group">
							<label>department</label>
							<!--提交的是部门的ID-->
							<select class="form-control" name="department">
								<option th:each="dept:${departments}" th:text="${dept.departmentName}" th:value="${dept.id}">1</option>
							</select>
						</div>
						<div class="form-group">
							<label>Birth</label>
							<input type="text" class="form-control" name="birth" placeholder="kuangstudy">
						</div>
						<button type="submit" class="btn btn-primary">添加</button>
					</form>
