<h2 class="title-t1">
	Dialogue Summary for the year
	${ed.dp.year?c}
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

<table class="tb-dp">
	<thead>
		<tr class="tr-top">
			<th style="width: 240px;">Degree of Target Achievement</th>
			<th>
				<span class="th1-txt">
					${ed.targetAchievement!}%
				</span>
				<span class="icon-arrow-right"></span>
				<span class="th1-txt">
				${ed.dp.targetCategory!}
				</span>
			</th>
			<th>Target Category*</th>
			<th class="blank"></th>
			<th style="width: 180px;">Overall Performance*</th>
			<th><span class="th1-txt">${ed.overallPerformance!}</span></th>
		</tr>
	</thead>
</table>
<table class="tb-dp">
	<thead>
		<tr>
			<th>Potential</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td style="padding-bottom: 4px;">
				<div class="dp-para" style="margin-bottom: 8px;">
					<label><strong>Development</strong> recommendations within 1 year: </label>
					<span class="radio <#if 'v' == ed.dp.devRecom1y!>checked</#if>">√</span><strong>vertical(v)</strong>
					<span class="radio <#if 'h' == ed.dp.devRecom1y!>checked</#if>">√</span><strong>horizontal(h)</strong>
					<span class="radio <#if 'r' == ed.dp.devRecom1y!>checked</#if>">√</span><strong>remain on position(r)</strong>
				</div>

				<#if 'h' == ed.dp.devRecom1y! || 'r' == ed.dp.devRecom1y! >
				<div class="dp-para">
					if "h" or "v", specific planned assignments:
					<span class="underline" style="min-width: 400px;">
					${ed.dp.devRecom1yField1!?xhtml}
					</span>
				</div>
				</#if>

				<#if 'v' == ed.dp.devRecom1y!>
				<div class="dp-para">
					<span class="underline">
					<#list developmentList as development>
						<#if development.code == ed.dp.devRecom1yField2!>
						${development.name?xhtml}
						</#if>
					</#list>
					</span>
					please specify function/position:
					<span class="underline" style="min-width: 400px;">
					${ed.dp.devRecom1yField3!?xhtml}
					</span>
				</div>
				</#if>
			</td>
		</tr>
		<tr>
			<td style="padding-bottom: 4px;">
				<div class="dp-para" style="margin-bottom: 8px;">
					<label><strong>Development</strong> recommendations within 3 year: </label>
					<span class="radio <#if 'v' == ed.dp.devRecom3y!>checked</#if>">√</span><strong>vertical(v)</strong>
					<span class="radio <#if 'h' == ed.dp.devRecom3y!>checked</#if>">√</span><strong>horizontal(h)</strong>
					<span class="radio <#if 'r' == ed.dp.devRecom3y!>checked</#if>">√</span><strong>remain on position(r)</strong>
				</div>

				<#if 'h' == ed.dp.devRecom3y! || 'r' == ed.dp.devRecom3y! >
				<div class="dp-para">
					Possible function or task: 
					<span class="underline" style="min-width: 400px;">
					${ed.dp.devRecom3yField1!?xhtml}
					</span>
				</div>
				</#if>

				<#if 'v' == ed.dp.devRecom3y!>
				<div class="dp-para">
					<span class="underline">
					<#list developmentList as development>
						<#if development.code == ed.dp.devRecom3yField2!>
						${development.name?xhtml}
						</#if>
					</#list>
					</span>						
					please specify division/department:
					<span class="underline" style="min-width: 400px;">
					${ed.dp.devRecom3yField3!?xhtml}
					</span>
				</div>
				</#if>
			</td>
		</tr>
		<tr>
			<th>Development measures and activities</th>
		</tr>
		<tr>
			<td>
				1. 
				<#list trainingSelect1.trainingList as training>
					<#if training.code == trainingSelect1.trainingCode!>
					${training.code} ${training.name?xhtml}
					</#if>
				</#list>
			</td>
		</tr>
		<tr>
			<td>
				2. 
				<#list trainingSelect2.trainingList as training>
					<#if training.code == trainingSelect2.trainingCode!>
					${training.code} ${training.name?xhtml}
					</#if>
				</#list>
			</td>
		</tr>
		<tr>
			<td>
				3. 
				<#list trainingSelect3.trainingList as training>
					<#if training.code == trainingSelect3.trainingCode!>
					${training.code} ${training.name?xhtml}
					</#if>
				</#list>
			</td>
		</tr>
		<tr>
			<td>
				4. 
				<#list languageTrainingList as language>
					<#if language.code == ed.dp.languageTrainingCode!>
					${language.name?xhtml}
					</#if>
				</#list>
			</td>
		</tr>
		<tr>
			<td>
				5. 
				${ed.dp.developmentPrograms!?xhtml}
			</td>
		</tr>
		<tr>
			<td>
				6. 
				${ed.dp.otherTrainings!?xhtml}
			</td>
		</tr>
		<tr>
			<th>Special internal and external activities, honorary appointments and qualification</th>
		</tr>
		<tr>
			<td>
				${ed.dp.specialActivities!?xhtml}
			</td>
		</tr>
		<tr>
			<th>Preferred operational area</th>
		</tr>
		<tr>
			<td>
				${ed.dp.operationalArea!?xhtml}
			</td>
		</tr>
	</tbody>
</table>

<div class="dp-desc">
	<div>*Target Category: T1, T2+, T2, T2-, T3</div>
	<div>*Overall Performance: P1, P2+, P2, P2-, P3</div>
</div>
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