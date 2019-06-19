/**
 * Zabuto Calendar
 *
 * Dependencies
 * - jQuery (2.0.3)
 * - Twitter Bootstrap (3.0.2)
 */
var userid;
// function timeout(json,userid2){
//	 userid=userid2;
//	 password=password2;
//	 var str = "\""+json+"\"";
//	 console.log("timeout+"+str);
//     if(str.indexOf("<html")>= 0||str.indexOf('userisnull')>-1){
//    	 $.post('../../../UserLoginCheckAction?controller=1&userid='+( userid),null,
// 	            function (json) {
//    		 console.log(json);
//             if(json=='success'){
//            	 window.location.href=url;
//             }else{
//             	window.location.href="../../../appTimeOut.jsp";
//             	return;
//             }
//    	 });
    	 /*$http.get().success(function (json) {
             //factorys.timeOut(json);
     		console.log(json);
             if(json=='success'){
//            	 window.location.href=url;
             }else{
             	window.location.href="../../../appTimeOut.jsp";
             	return;
             }
         });
         //window.location.href="../../../appTimeOut.jsp";
         return;*/
//     }
// }
 
var allEvents = [];
var thisYear = "";
var idrandom= "";
var error = "";
var today  = "";
if (typeof jQuery == 'undefined') {
    throw new Error('jQuery is not loaded');
}
        /* ----- Helper functions ----- */

function isToday(year, month, day) {
    var todayObj = new Date();
    var dateObj = new Date(year, month, day);
    return (dateObj.toDateString() == todayObj.toDateString());
}

function getFullDate(d){
	if(d==""){
		return "";
	}
	var d_array = d.split("-");
	var d_year = d_array[0];
	var d_month = d_array[1].length>1?d_array[1]:"0"+d_array[1];
	var d_day =  d_array[2].length>1?d_array[2]:"0"+d_array[2];
		return d_year+"-"+d_month+"-"+d_day;
}
function initFestival(year,month,day,$dayElement,lunarValue,dayId){
    //常量 工作日
    var TYPE_DAY = "day ";
    //常量 休息日
    var TYPE_REST = "rest ";
    //常量 职能部门休息日
    var TYPE_OFC = "ofc ";
    //常量 当天
    var TYPE_TODAY = "badge badge-today ";
        //view_d_1 上方显示
        //view_d_2 下方显示
        //type 显示方式 ：正常，放假，事件
    var view_d_1 = day,view_d_2=lunarValue,type = TYPE_DAY;

        //默认下方显示内容
    var lunarValue_ = lunarValue;

    //年
    var dateYearStr = year;
    //月
    var dateDay = (day.toString().length==1)?'0'+day:day.toString();
    //日
    var dateMonthStr =Number(month) +1;
        dateMonthStr = (dateMonthStr.toString().length==1)?'0'+dateMonthStr:dateMonthStr;
    //年-月-日
    var d = year+"-"+dateMonthStr+"-"+dateDay
    //年-月-日
    var d2 = year+"-"+(month+1)+"-"+day
    //完整农历显示
    var ftv = showCal(d);

    //遍历节日
    for(var i=0;i<sFtv.length;i++){
        var isRest = sFtv[i].substring(4,5);
        var sFtvName = sFtv[i].substring(5,sFtv.length);
        if(sFtv[i].indexOf(dateMonthStr+dateDay)>-1){
            if(isRest=='*'){
                view_d_2 =  sFtvName;
                type  += TYPE_REST;
            }else
            if(sFtvName!=''&&sFtvName.trim()!=''){
                view_d_2 = sFtvName;
            }
        }
    }

        if(ftv.indexOf("正月初一")>-1){
            view_d_2 = lFtv[0].substring(5,sFtv.length);
            type += TYPE_REST;
        }else
        if(ftv.indexOf("正月十五")>-1){
            view_d_2 = lFtv[1].substring(5,sFtv.length);
        }else
        if(ftv.indexOf("五月初五")>-1){
            view_d_2 = lFtv[2].substring(5,sFtv.length);
        }else
        if(ftv.indexOf("七月初七")>-1){
            view_d_2 = lFtv[3].substring(5,sFtv.length);
        }else
        if(ftv.indexOf("七月十五")>-1){
            view_d_2 = lFtv[4].substring(5,sFtv.length);
        }else
        if(ftv.indexOf("八月十五")>-1){
            view_d_2 = lFtv[5].substring(5,sFtv.length);
        }else
        if(ftv.indexOf("九月初九")>-1){
            view_d_2 = lFtv[6].substring(5,sFtv.length);
        }else
        if(ftv.indexOf("腊月初八")>-1){
            view_d_2 = lFtv[7].substring(5,sFtv.length);
        }else
        if(ftv.indexOf("腊月十四")>-1){
            view_d_2 = lFtv[8].substring(5,sFtv.length);
        }else
        if(ftv.indexOf("腊月三十")>-1){
            type += TYPE_REST;
            view_d_2 = lFtv[9].substring(5,sFtv.length);
        }

//2015年节假日(不包含星期日)
    for(var i=0;i<holidays2015.length;i++){
        if(d2==holidays2015[i]){
            type += TYPE_REST;
        }
    }


//2015年节假日(不包含星期日)
    for(var i=0;i<holidays2015.length;i++){
        if(d2==holidays2015[i]){
            type += TYPE_REST;
        }
    }

// 2015年春节期间职能部门放假的日期
    for(var i=0;i<blueDays2015.length;i++){
        if(d2==blueDays2015[i]){
            type += TYPE_OFC;
        }
    }
// 2015年春节期间职能部门放假的日期
    for(var i=0;i<blackSundays2015.length;i++){
        if(d2==blackSundays2015[i]){
            type += TYPE_DAY;
        }
    }

//今天
    if(isToday(year,month,day)){
    	dayElement = $('<div id="' + dayId + '" class="'+type+'" ><div class="'+TYPE_TODAY+'" >' + view_d_1+'</span><br/><span class="calendar-lunar">'+
        view_d_2+ '</span></div>');
    }else{
   $dayElement = $('<div id="' + dayId + '" class="'+type+'" >' + view_d_1+'<br/><span class="calendar-lunar">'+
        view_d_2+ '</span></div>');
    }
   
    $dayElement.data('day', view_d_1);

    if(updateYear!=thisYear){
        return $dayElement;
    }

    ////农历节日 *表示放假日

    return $dayElement;
}














/**
 * Create calendar
 *
 * @param options
 * @returns {*}
 */
$.fn.zabuto_calendar = function (options) {
    var opts = $.extend({}, $.fn.zabuto_calendar_defaults(), options);
    var languageSettings = $.fn.zabuto_calendar_language(opts.language);
    opts = $.extend({}, opts, languageSettings);

    this.each(function () {
        var $calendarElement = $(this);
        idrandom= Math.floor(Math.random() * 99999).toString(36);
        $calendarElement.attr('id', "zabuto_calendar_" + idrandom);

        $calendarElement.data('initYear', opts.year);
        $calendarElement.data('initMonth', opts.month);
        $calendarElement.data('monthLabels', opts.month_labels);
        $calendarElement.data('weekStartsOn', opts.weekstartson);
        $calendarElement.data('navIcons', opts.nav_icon);
        $calendarElement.data('dowLabels', opts.dow_labels);
        $calendarElement.data('showToday', opts.today);
        $calendarElement.data('showDays', opts.show_days);
        $calendarElement.data('showPrevious', opts.show_previous);
        $calendarElement.data('showNext', opts.show_next);
        $calendarElement.data('cellBorder', opts.cell_border);
        $calendarElement.data('ajaxSettings', opts.ajax);
        $calendarElement.data('legendList', opts.legend);
        $calendarElement.data('actionFunction', opts.action);
        $calendarElement.data('actionNavFunction', opts.action_nav);
        userid=opts.userid;
//        password=opts.password;
        console.log(userid+"useridddddddddddddd");
        drawCalendar();

        function drawCalendar() {
            var dateInitYear = parseInt($calendarElement.data('initYear'));
            thisYear  =  dateInitYear;
            var dateInitMonth = parseInt($calendarElement.data('initMonth')) - 1;
            var dateInitObj = new Date(dateInitYear, dateInitMonth, 1, 0, 0, 0, 0);
            $calendarElement.data('initDate', dateInitObj);

            var tableClassHtml = ($calendarElement.data('cellBorder') === true) ? ' table-bordered' : '';

            $tableObj = $('<table class="table' + tableClassHtml + '"></table>');
            $tableObj = drawTable($calendarElement, $tableObj, dateInitObj.getFullYear(), dateInitObj.getMonth());

            $legendObj = drawLegend($calendarElement);

            var $containerHtml = $('<div class="zabuto_calendar" id="' + $calendarElement.attr('id') + '"></div>');
            $containerHtml.append($tableObj);
                $containerHtml.append($legendObj);

            $calendarElement.append($containerHtml);
        }

        function drawTable($calendarElement, $tableObj, year, month) {
            var dateCurrObj = new Date(year, month, 1, 0, 0, 0, 0);
            $calendarElement.data('currDate', dateCurrObj);

            $tableObj.empty();
            $tableObj = appendMonthHeader($calendarElement, $tableObj, year, month);
            $tableObj = appendDayOfWeekHeader($calendarElement, $tableObj);
            $tableObj = appendDaysOfMonth($calendarElement, $tableObj, year, month);
            checkEvents($calendarElement, year, month);
            return $tableObj;
        }

        function drawLegend($calendarElement) {
            var $legendObj = $('<div class="legend" id="' + $calendarElement.attr('id') + '_legend"></div>');
            var legend = $calendarElement.data('legendList');
            if (typeof(legend) == 'object' && legend.length > 0) {
                $(legend).each(function (index, item) {
                    if (typeof(item) == 'object') {
                        if ('type' in item) {
                            var itemLabel = '';
                            if ('label' in item) {
                                itemLabel = item.label;
                            }

                            switch (item.type) {
                                case 'text':
                                    if (itemLabel !== '') {
                                        var itemBadge = '';
                                        if ('badge' in item) {
                                            if (typeof(item.classname) === 'undefined') {
                                                var badgeClassName = 'badge-event';
                                            } else {
                                                var badgeClassName = item.classname;
                                            }
                                            itemBadge = '<span class="badge ' + badgeClassName + '">' + item.badge + '</span> ';
                                        }
                                        $legendObj.append('<span class="legend-' + item.type + '">' + itemBadge + itemLabel + '</span>');
                                    }
                                    break;
                                case 'block':
                                    if (itemLabel !== '') {
                                        itemLabel = '<span>' + itemLabel + '</span>';
                                    }
                                    if (typeof(item.classname) === 'undefined') {
                                        var listClassName = 'event';
                                    } else {
                                        var listClassName = 'event-styled ' + item.classname;
                                    }
                                    $legendObj.append('<span class="legend-' + item.type + '"><ul class="legend"><li class="' + listClassName + '"></li></u>' + itemLabel + '</span>');
                                    break;
                                case 'list':
                                    if ('list' in item && typeof(item.list) == 'object' && item.list.length > 0) {
                                        var $legendUl = $('<ul class="legend"></u>');
                                        $(item.list).each(function (listIndex, listClassName) {
                                            $legendUl.append('<li class="' + listClassName + '"></li>');
                                        });
                                        $legendObj.append($legendUl);
                                    }
                                    break;
                                case 'spacer':
                                    $legendObj.append('<span class="legend-' + item.type + '"> </span>');
                                    break;

                            }
                        }
                    }
                });
            }

            return $legendObj;
        }

        function appendMonthHeader($calendarElement, $tableObj, year, month) {
            thisYear = year;
            var navIcons = $calendarElement.data('navIcons');
            var $prevMonthNavIcon = $('<span><span class="glyphicon glyphicon-chevron-left"></span></span>');
            var $nextMonthNavIcon = $('<span><span class="glyphicon glyphicon-chevron-right"></span></span>');
            if (typeof(navIcons) === 'object') {
                if ('prev' in navIcons) {
                    $prevMonthNavIcon.html(navIcons.prev);
                }
                if ('next' in navIcons) {
                    $nextMonthNavIcon.html(navIcons.next);
                }
            }

            var prevIsValid = $calendarElement.data('showPrevious');
            if (typeof(prevIsValid) === 'number' || prevIsValid === false) {
                prevIsValid = checkMonthLimit($calendarElement.data('showPrevious'), true);
            }

            var $prevMonthNav = $('<div class="calendar-month-navigation"></div>');
            $prevMonthNav.attr('id', $calendarElement.attr('id') + '_nav-prev');
            $prevMonthNav.data('navigation', 'prev');
            if (prevIsValid !== false) {
                prevMonth = (month - 1);
                prevYear = year;
                if (prevMonth == -1) {
                    prevYear = (prevYear - 1);
                    prevMonth = 11;
                }
                $prevMonthNav.data('to', {year: prevYear, month: (prevMonth + 1)});
                $prevMonthNav.append($prevMonthNavIcon);
                if (typeof($calendarElement.data('actionNavFunction')) === 'function') {
                    $prevMonthNav.click($calendarElement.data('actionNavFunction'));
                }
                $prevMonthNav.click(function (e) {
                    drawTable($calendarElement, $tableObj, prevYear, prevMonth);
                });
            }

            var nextIsValid = $calendarElement.data('showNext');
            if (typeof(nextIsValid) === 'number' || nextIsValid === false) {
                nextIsValid = checkMonthLimit($calendarElement.data('showNext'), false);
            }

            var $nextMonthNav = $('<div class="calendar-month-navigation"></div>');
            $nextMonthNav.attr('id', $calendarElement.attr('id') + '_nav-next');
            $nextMonthNav.data('navigation', 'next');
            if (nextIsValid !== false) {
                nextMonth = (month + 1);
                nextYear = year;
                if (nextMonth == 12) {
                    nextYear = (nextYear + 1);
                    nextMonth = 0;
                }
                $nextMonthNav.data('to', {year: nextYear, month: (nextMonth + 1)});
                $nextMonthNav.append($nextMonthNavIcon);
                if (typeof($calendarElement.data('actionNavFunction')) === 'function') {
                    $nextMonthNav.click($calendarElement.data('actionNavFunction'));
                }
                $nextMonthNav.click(function (e) {
                    drawTable($calendarElement, $tableObj, nextYear, nextMonth);
                });
            }

            var monthLabels = $calendarElement.data('monthLabels');

            var $prevMonthCell = $('<th colspan="2"></th>').append($prevMonthNav);
            var $nextMonthCell = $('<th colspan="2"></th>').append($nextMonthNav);

            var $currMonthLabel = $('<span>' + monthLabels[month] + ' ' + year + '</span>');
            $currMonthLabel.dblclick(function () {
                var dateInitObj = $calendarElement.data('initDate');
                drawTable($calendarElement, $tableObj, dateInitObj.getFullYear(), dateInitObj.getMonth());
            });

            var $currMonthCell = $('<th class="calendar-head"  colspan="3"></th>');
            $currMonthCell.append($currMonthLabel);

            var $monthHeaderRow = $('<tr class="calendar-month-header"></tr>');
            $monthHeaderRow.append($prevMonthCell, $currMonthCell, $nextMonthCell);

            $tableObj.append($monthHeaderRow);
            return $tableObj;
        }

        function appendDayOfWeekHeader($calendarElement, $tableObj) {
            if ($calendarElement.data('showDays') === true) {
                var weekStartsOn = $calendarElement.data('weekStartsOn');
                var dowLabels = $calendarElement.data('dowLabels');
                if (weekStartsOn === 0) {
                    var dowFull = $.extend([], dowLabels);
                    var sunArray = new Array(dowFull.pop());
                    dowLabels = sunArray.concat(dowFull);
                }

                var $dowHeaderRow = $('<tr class="calendar-dow-header"></tr>');
                $(dowLabels).each(function (index, value) {
                    $dowHeaderRow.append('<th>' + value + '</th>');
                });
                $tableObj.append($dowHeaderRow);
            }
            return $tableObj;
        }

        function appendDaysOfMonth($calendarElement, $tableObj, year, month) {
            var ajaxSettings = $calendarElement.data('ajaxSettings');
            var weeksInMonth = calcWeeksInMonth(year, month);
            var lastDayinMonth = calcLastDayInMonth(year, month);
            var firstDow = calcDayOfWeek(year, month, 1);
            var lastDow = calcDayOfWeek(year, month, lastDayinMonth);
            var currDayOfMonth = 1;

            var weekStartsOn = $calendarElement.data('weekStartsOn');
            if (weekStartsOn === 0) {
                if (lastDow == 6) {
                    weeksInMonth++;
                }
                if (firstDow == 6 && (lastDow == 0 || lastDow == 1 || lastDow == 5)) {
                    weeksInMonth--;
                }
                firstDow++;
                if (firstDow == 7) {
                    firstDow = 0;
                }
            }

            for (var wk = 0; wk < weeksInMonth; wk++) {
                var $dowRow = $('<tr class="calendar-dow"></tr>');
                for (var dow = 0; dow < 7; dow++) {
                    if (dow < firstDow || currDayOfMonth > lastDayinMonth) {
                        $dowRow.append('<td></td>');
                    } else {
                        var dateId = $calendarElement.attr('id') + '_' + dateAsString(year, month, currDayOfMonth);
                        var dayId = dateId + '_day';
                        //显示农历
                        var lunarValue =  GetLunarDaySmp(year, month, currDayOfMonth);

                        var $dayElement = $('<div id="' + dayId + '" class="day" >' + currDayOfMonth+'<br/><span class="calendar-lunar">'+
                            lunarValue+ '</span></div>');
                        $dayElement.data('day', currDayOfMonth);

                        if ($calendarElement.data('showToday') === true) {
                            if (isToday(year, month, currDayOfMonth)) {
                                lunarValue =  GetLunarDaySmp(year, month, currDayOfMonth);
                                $dayElement.html('<span class="badge badge-today">' + currDayOfMonth +'</span><br/><span class="calendar-lunar">'+
                                    lunarValue+ '</span>');
                            }
                        }

                        //------------------------------------------------
                        $dayElement = initFestival(year,month,currDayOfMonth,$dayElement,lunarValue,dayId);


                        var $dowElement = $('<td id="' + dateId + '"></td>');
                        $dowElement.append($dayElement);

                        $dowElement.data('date', dateAsString(year, month, currDayOfMonth));
                        $dowElement.data('hasEvent', false);

                        if (typeof($calendarElement.data('actionFunction')) === 'function') {
                            $dowElement.addClass('dow-clickable');
                            $dowElement.click(function () {
                                $calendarElement.data('selectedDate', $(this).data('date'));
                            });
                            $dowElement.click($calendarElement.data('actionFunction'));
                        }

                        $dowRow.append($dowElement);

                        currDayOfMonth++;
                    }
                    if (dow == 6) {
                        firstDow = 0;
                    }
                }

                $tableObj.append($dowRow);
            }
            return $tableObj;
        }

        /* ----- Modal functions ----- */

        function createModal(id, title, body, footer) {
            var $modalHeaderButton = $('<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>');
            var $modalHeaderTitle = $('<h4 class="modal-title" id="' + id + '_modal_title">' + title + '</h4>');

            var $modalHeader = $('<div class="modal-header"></div>');
            $modalHeader.append($modalHeaderButton);
            $modalHeader.append($modalHeaderTitle);

            var $modalBody = $('<div class="modal-body" id="' + id + '_modal_body">' + body + '</div>');

            var $modalFooter = $('<div class="modal-footer" id="' + id + '_modal_footer"></div>');
            if (typeof(footer) !== 'undefined') {
                var $modalFooterAddOn = $('<div>' + footer + '</div>');
                $modalFooter.append($modalFooterAddOn);
            }

            var $modalContent = $('<div class="modal-content"></div>');
            $modalContent.append($modalHeader);
            $modalContent.append($modalBody);
            $modalContent.append($modalFooter);

            var $modalDialog = $('<div class="modal-dialog"></div>');
            $modalDialog.append($modalContent);

            var $modalFade = $('<div class="modal fade" id="' + id + '_modal" tabindex="-1" role="dialog" aria-labelledby="' + id + '_modal_title" aria-hidden="true"></div>');
            $modalFade.append($modalDialog);

            $modalFade.data('dateId', id);
            $modalFade.attr("dateId", id);

            return $modalFade;
        }

        /* ----- Event functions ----- */

        function checkEvents($calendarElement, year, month) {
            var ajaxSettings = $calendarElement.data('ajaxSettings');

            $calendarElement.data('events', false);

            if (ajaxSettings === false) {
                return true;
            }

            if (typeof(ajaxSettings) != 'object' || typeof(ajaxSettings.url) == 'undefined') {
                alert('Invalid calendar event settings');
                return false;
            }

//            var data = { year: year, month: (month + 1)};
            var monthStr = "{\"month\":\""+(year+"-"+(month+1))+"\"}";

			var data ={ "content":monthStr, "oprateType": "QUERY_MONTH", "userid":useridss};
            aaa(ajaxSettings,data);
          
//            
//            $.ajax({
//                type: 'POST',
//                url: ajaxSettings.url,
//                data: data,
//                dataType: 'json'
//            }).done(function (response) {
//            	timeout(response);
//            	if(response.resultCode==0){
//            		error = "读取事件失败";
//            		console.log(error);
//            	}else{
//	                var events = [];
//	                var resultContent = response.resultContent;
//	                
//	                var dataList = eval("("+resultContent+")").dataList;
//	                if(dataList!=null){
//	                $.each(dataList, function (k, v) {
//	                	v.date = getFullDate(v.date);
//	                    events.push(v);
//	                });
//	                $calendarElement.data('events', events);
//	                allEvents = events;
//	                drawEvents($calendarElement);
//                }
//                }
//            });
        }
        
        function aaa(ajaxSettings,data){
        	  $.post(ajaxSettings.url,data,
        	            function (response) {
//        	            	alert(response);
//        		  			timeout(response,userid);
//        		  			console.log(userid+"------aaa-----");
        		  			console.log(response+"response");
//        		            if(response=='userisnull'){
//        		            	aaa(ajaxSettings,data);
//        		            }else{
        		            	response = eval("("+response+")");
            	            	if(response.resultCode==0){
            	            		error = "读取事件失败";
            	            		console.log(error);
            	            	}else{
            		                var events = [];
            		                var resultContent = response.resultContent;
            		                
            		                var dataList = eval("("+resultContent+")").dataList;
            		                if(dataList!=null){
            		                $.each(dataList, function (k, v) {
            		                	v.date = getFullDate(v.date);
            		                    events.push(v);
            		                });
            		                $calendarElement.data('events', events);
            		                allEvents = events;
            		                drawEvents($calendarElement);
//            	                }
            	                }
        		            }
        	            });
        }
        
        function drawEvents($calendarElement) {
            var ajaxSettings = $calendarElement.data('ajaxSettings');
            var events = $calendarElement.data('events');
            allEvents = events;
            if (events !== false) {
            
                $(events).each(function (index, value) {
                    var id = $calendarElement.attr('id') + '_' + getFullDate(value.date);
                    var $dowElement = $('#' + id);
                    var $dayElement = $('#' + id + '_day');

                    
                    $dowElement.data('hasEvent', true);

                    if (typeof(value.title) !== 'undefined') {
                        $dowElement.attr('title', value.title);
                    }

                    if (typeof(value.classname) === 'undefined') {
                        $dowElement.addClass('event');
                    } else {
                        $dowElement.addClass('event-styled');
                        $dayElement.addClass(value.classname);
                    }

                    if (typeof(value.badge) !== 'undefined' && value.badge !== false) {
                        var badgeClass = (value.badge === true) ? '' : ' badge-' + value.badge;
                        var dayLabel = $dayElement.data('day');
                        var  d   =   new   Date(value.date.replace(/-/g,   "/"));
                        $dayElement.html('<span class="badge badge-event' + badgeClass + '">' + dayLabel +'</span><br/><span class="calendar-lunar">'+
                            GetLunarDaySmp(d.getFullYear(), d.getMonth(), d.getDate())
                            +  '</span>');
                    }

                    if (typeof(value.body) !== 'undefined') {
                        if ('modal' in ajaxSettings && (ajaxSettings.modal === true)) {
                            $dowElement.addClass('event-clickable');

                            var $modalElement = createModal(id, value.title, value.body, value.footer);
                            $('body').append($modalElement);

                            $('#' + id).click(function () {
                                $('#' + id + '_modal').modal();
                            });
                        }
                    }
                    
                    //判断今天有事件，加载事件
	                    var todayDate = new Date();
	                    var todayStr = 	getFullDate(todayDate.getFullYear()+"-"+(todayDate.getMonth()+1)+"-"+todayDate.getDate());
	                    var eventDate = value.date;
	                    if(todayStr === eventDate){
	                    	    setSchedule(eventDate,queryDayEventRequest(eventDate));
	                    }
                });
                
               
            }
        }

        /* ----- Helper functions ----- */

        function isToday(year, month, day) {
            var todayObj = new Date();
            var dateObj = new Date(year, month, day);
            return (dateObj.toDateString() == todayObj.toDateString());
        }

        function dateAsString(year, month, day) {
            d = (day < 10) ? '0' + day : day;
            m = month + 1;
            m = (m < 10) ? '0' + m : m;
            return year + '-' + m + '-' + d;
        }

        function calcDayOfWeek(year, month, day) {
            var dateObj = new Date(year, month, day, 0, 0, 0, 0);
            var dow = dateObj.getDay();
            if (dow == 0) {
                dow = 6;
            } else {
                dow--;
            }
            return dow;
        }

        function calcLastDayInMonth(year, month) {
            var day = 28;
            while (checkValidDate(year, month + 1, day + 1)) {
                day++;
            }
            return day;
        }

        function calcWeeksInMonth(year, month) {
            var daysInMonth = calcLastDayInMonth(year, month);
            var firstDow = calcDayOfWeek(year, month, 1);
            var lastDow = calcDayOfWeek(year, month, daysInMonth);
            var days = daysInMonth;
            var correct = (firstDow - lastDow);
            if (correct > 0) {
                days += correct;
            }
            return Math.ceil(days / 7);
        }

        function checkValidDate(y, m, d) {
            return m > 0 && m < 13 && y > 0 && y < 32768 && d > 0 && d <= (new Date(y, m, 0)).getDate();
        }

        function checkMonthLimit(count, invert) {
            if (count === false) {
                count = 0;
            }
            var d1 = $calendarElement.data('currDate');
            var d2 = $calendarElement.data('initDate');

            var months;
            months = (d2.getFullYear() - d1.getFullYear()) * 12;
            months -= d1.getMonth() + 1;
            months += d2.getMonth();

            if (invert === true) {
                if (months < (parseInt(count) - 1)) {
                    return true;
                }
            } else {
                if (months >= (0 - parseInt(count))) {
                    return true;
                }
            }
            return false;
        }
    }); // each()

    return this;
};

/**
 * Default settings
 *
 * @returns object
 *   language:          string,
 *   year:              integer,
 *   month:             integer,
 *   show_previous:     boolean|integer,
 *   show_next:         boolean|integer,
 *   cell_border:       boolean,
 *   today:             boolean,
 *   show_days:         boolean,
 *   weekstartson:      integer (0 = Sunday, 1 = Monday),
 *   nav_icon:          object: prev: string, next: string
 *   ajax:              object: url: string, modal: boolean,
 *   legend:            object array, [{type: string, label: string, classname: string}]
 *   action:            function
 *   action_nav:        function
 */
$.fn.zabuto_calendar_defaults = function () {
    var now = new Date();
    var year = now.getFullYear();
    var month = now.getMonth() + 1;
    var settings = {
        language: false,
        year: year,
        month: month,
        show_previous: true,
        show_next: true,
        cell_border: false,
        today: false,
        show_days: true,
        weekstartson: 1,
        nav_icon: false,
        ajax: false,
        legend: false,
        action: false,
        action_nav: false
    };
    return settings;
};

/**
 * Language settings
 *
 * @param lang
 * @returns {{month_labels: Array, dow_labels: Array}}
 */
$.fn.zabuto_calendar_language = function (lang) {
    if (typeof(lang) == 'undefined' || lang === false) {
        lang = 'en';
    }

    switch (lang.toLowerCase()) {
        case 'en':
            return {
                month_labels: ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"],
                dow_labels: ["Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"]
            };
            break;

        case 'cn':
            return {
                month_labels: ["1月", "2月", "3月", "4月", "5月", "6月", "7月", "8月", "9月", "10月", "11月", "12月"],
               // dow_labels: ["周一", "周二", "周三", "周四", "周五", "周六", "周日"]
                dow_labels: ["一", "二", "三", "四", "五", "六", "日"]
            };
            break;
    }

};
