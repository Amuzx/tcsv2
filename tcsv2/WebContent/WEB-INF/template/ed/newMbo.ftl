<table class="tb-mbo">
	<thead>
		<tr>
			<th rowspan="2" class="th0">
				<h2 class="title-t1">
					Management by Objective for the year
					${ed.newMbo.year?c}
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
			<th rowspan="2">Measured Variable</th>
			<th rowspan="2" style="width: 84px;">Deadline</th>
			<th rowspan="2" style="width: 70px;">Weighting Factor</th>
			<th colspan="2" class="th1">Target Evaluation</th>
		</tr>
		<tr>
			<th class="th2" style="width: 70px;">Degree of Fulfillment</th>
			<th class="th2 last" style="width: 70px;">Target Achievement</th>
		</tr>
	</thead>
	<tbody>

		<tr>
			<th colspan="6">Function related objectives</th>
		</tr>

		<#list ed.newMbo.functionObjectiveList as objective>
		<tr>
			<td>
				${objective.name!?xhtml}
			</td>
			<td>
				${objective.measuredVariable!?xhtml}
			</td>
			<td class="tx-c">
				<#if objective.deadline??>${objective.deadline?string("yyyy-MM-dd")}</#if>
			</td>
			<td class="tx-c">
				${objective.weightingFactor!}
			</td>
			<td class="tx-r">
				${objective.fulfillment!}%
			</td>
			<td class="tx-r">
				${objective.targetAchievement!}%
			</td>
		</tr>
		</#list>

		<tr>
			<td class="gap" colspan="6"></td>
		</tr>

		<tr>
			<th colspan="6">Personal related objectives</th>
		</tr>
		<#list ed.newMbo.personalObjectiveList as objective>
		<tr>
			<td>
				${objective.name!?xhtml}
			</td>
			<td>
				${objective.measuredVariable!?xhtml}
			</td>
			<td class="tx-c">
				<#if objective.deadline??>${objective.deadline?string("yyyy-MM-dd")}</#if>
			</td>
			<td class="tx-c">
				${objective.weightingFactor!}
			</td>
			<td class="tx-r">
				${objective.fulfillment!}%
			</td>
			<td class="tx-r">
				${objective.targetAchievement!}%
			</td>
		</tr>
		</#list>
	</tbody>
	<tfoot>
		<tr class="tr1">
			<td></td>
			<td></td>
			<td class="tx-r td3">Σ</td>
			<td class="tx-c td4">
				<div class="sum">
					${ed.newMbo.weightingFactor!}
				</div>
			</td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td>
				<#if ed.status == 3>
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
				</#if>
			</td>
			<td colspan="4" class="td1">Degree of Target Achievement</td>
			<td class="td2">
				${ed.newMbo.targetAchievement!}%
			</td>
		</tr>
	</tfoot>
</table>