Ext.define('oa.model.Project', {
    extend: 'Ext.data.Model',

    fields: [{
        name: 'id',
        type: 'int'
    }, 
    'name',
    'company',
    {
        name: 'createTime',
        convert: function(v, record) {
            return Ext.Date.format(new Date(v), 'Y-m-d H:i:s');
        }
    }],

    validators: {}
});