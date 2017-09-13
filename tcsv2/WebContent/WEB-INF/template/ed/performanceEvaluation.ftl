<table class="tb-pe">
	<thead>
		<tr>
			<th rowspan="2" colspan="2" class="th0">
				<h2 class="title-t1">
					Performance Evaluation for the year
					${ed.pe.year?c}
				</h2>
				<div class="info-i1">
					<div class="item">
						<span class="label">Name: </span>
						<span class="value">${user.name}</span>
					</div>
					<div class="item">
						<span class="label">Staff Code: </span>
						<span class="value">${user.staffCode}</span>
					</div>
					<div class="item">
						<span class="label">Dept.:</span>
						<span class="value">${user.directDepartment!?xhtml}</span>
					</div>
				</div>
			</th>
			<th class="th1">far exceeds requirements</th>
			<th class="th1">exceeds requirements</th>
			<th class="th1">fully meets requirements</th>
			<th class="th1">partially meets requirements</th>
			<th class="th1">in need of improvement</th>
		</tr>
		<tr>
			<th>P1</th>
			<th>P2+</th>
			<th>P2</th>
			<th>P2-</th>
			<th>P3</th>
		</tr>
	</thead>
	<tbody>
		<#list competenceGroupList as competenceGroup>
			<#if competenceGroup_index != 0>
				<tr>
					<td class="gap" colspan="7"></td>
				</tr>
			</#if>

			<tr>
				<th rowspan="${competenceGroup.competenceList?size + 1}">${competenceGroup.name?xhtml}</th>
			</tr>

			<#list competenceGroup.competenceList as competence>
				<tr>
					<td>
						${competence.name?xhtml}
					</td>
					<td class="td4"><#if 'P1' == ed.pe.performanceItemMap[competence.code]['performance']!>√</#if></td>
					<td class="td4"><#if 'P2+' == ed.pe.performanceItemMap[competence.code]['performance']!>√</#if></td>
					<td class="td4"><#if 'P2' == ed.pe.performanceItemMap[competence.code]['performance']!>√</#if></td>
					<td class="td4"><#if 'P2-' == ed.pe.performanceItemMap[competence.code]['performance']!>√</#if></td>
					<td class="td4"><#if 'P3' == ed.pe.performanceItemMap[competence.code]['performance']!>√</#if></td>
				</tr>
			</#list>
		</#list>

		<tr>
			<td class="gap last" colspan="7"></td>
		</tr>
		<tr>
			<td class="td1">
			</td>
			<td class="td2">Overall Performance</td>
			<td class="td3"><#if 'P1' == ed.pe.overallPerformance!>√</#if></td>
			<td class="td3"><#if 'P2+' == ed.pe.overallPerformance!>√</#if></td>
			<td class="td3"><#if 'P2' == ed.pe.overallPerformance!>√</#if></td>
			<td class="td3"><#if 'P2-' == ed.pe.overallPerformance!>√</#if></td>
			<td class="td3"><#if 'P3' == ed.pe.overallPerformance!>√</#if></td>
		</tr>
	</tbody>
	<#if ed.status == 3>
	<tfoot>
		<tr>
			<td colspan="7">
				<div class="sign-field">
					<div class="item">
						<div class="label" style="width: 80px;">
						Date
						</div>
					</div>
					<div class="item">
						<div class="label" style="width: 120px;">
						Supervisor
						</div>
					</div>
					<div class="item" style="width: 120px;">
						<div class="label">
						Employee
						</div>
					</div>
				</div>
			</td>
		</tr>
	</tfoot>
	</#if>
</table>