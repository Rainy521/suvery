/**
 * Created by Administrator on 2017/11/22.
 */
// 纯JS省市区三级联动
// 2011-11-30 by http://www.cnblogs.com/zjfree
var industryInit = function(_industryId, defaultIndustry)
{
    var industry = document.getElementById(_industryId);
    function industrySelect(ind, str)
    {
        for(var i=0; i<ind.length; i++)
        {
            if(ind.options[i].value == str)
            {
                ind.selectedIndex = i;
                return;
            }
        }
    }
    function indAddOption(ind, str, obj)
    {
    	
        var option = document.createElement("OPTION");
        ind.options.add(option);
        option.innerText = str;
        option.value = str;
        option.obj = obj;
        
    }
    for(var i=0; i<industryList.length; i++)
    {
    	
        indAddOption(industry, industryList[i].name, industryList[i]);
    }
    
    industrySelect(industry, defaultIndustry); 
    industry.options.length = industryList.length;
}

var industryList = [
	{name:'--行业类型--'},
	{name:'计算机硬件及网络设备'},
	{name:'计算机软件 '},
	{name:'IT服务(系统/数据/维护)/多领域经营'},
	{name:'互联网/电子商务'},
	{name:'网络游戏'},
	{name:'通讯(设备/运营/增值服务)'},
	{name:'电子技术/半导体/集成电路'},
	{name:'仪器仪表及工业自动化'},
	{name:'金融/银行/投资/基金/证券'},
	{name:'保险'},
	{name:'房地产/建筑/建材/工程'},
	{name:'家居/室内设计/装饰装潢'},
	{name:'物业管理/商业中心'},
	{name:'广告/会展/公关/市场推销'},
	{name:'媒体/出版/影视/文化/艺术'},
	{name:'印刷/包装/造纸'},
	{name:'咨询/管理产业/法律/财会'},
	{name:'教育/培训'},
	{name:'检验/检测/认证'}
];