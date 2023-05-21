$(document).ready(function () {
    $('button.deltest').click(function () {
        let id = $(this).attr('id')
        console.log('deleting test')

        $.ajax({
            url: '/test/delete',
            type: 'POST',
            data: 'id=' + id,

            success: function (res) {
                location.reload()
            }
        })
    })

    $('button.deltopic').click(function () {
        let id = $(this).attr('id')
        console.log('deleting topic')

        $.ajax({
            url: '/topic/delete',
            type: 'POST',
            data: 'id=' + id,

            success: function (res) {
                location.reload()
            }
        })
    })
})